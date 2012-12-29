package controller;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * THis Servlet is for PayPal IPN (Instant Payment Notification) Purposes.
 * It will store the information gained from a PayPal Transaction in a database
 * and update user credit points on succesfull payments.
 * See http://www.paypal.com/ipn/ for more details.
 * 
 * @author <a href="sven@wagenhoefer.com">Sven Wagenh�fer</a>
 *
 * 
 */
public class PayPalIPNServlet extends HttpServlet {

	private static final String CONTENT_TYPE =
		"text/html; charset=windows-1252";
	private Connection cn;
	RandomAccessFile logFile;

   
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		String SQLServer = "127.0.0.1";
		String SQLUser = "root";
		String SQLPassword = "";
		String SQLDatabase = "jacsy";

		// Load the MySQL-JDBC-Driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

		}
		catch (Exception ex) {
			System.out.println(ex.toString());
			System.exit(1);
		}
		//		Initiate a Connection to the MySQL Database
		try {
			this.cn =
				DriverManager.getConnection(
					"jdbc:mysql://"
						+ SQLServer
						+ "/"
						+ SQLDatabase
						+ "?user="
						+ SQLUser
						+ "&password="
						+ SQLPassword);
			System.out.println("Connection to MySQL Server set.... ");

		}
		catch (SQLException ex) {
			// handle any errors 
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			System.exit(1);
		}
		try {
			logFile = new RandomAccessFile("log.txt", "rw");
		}
		catch (FileNotFoundException e) {
		}
	}

	/**
	* Hauptserviceroutine
	* @param req ServeltRequest
	* @param res ServletResponse
	*/
    
	public void service(
		HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		try {
			//   read post from PayPal system and add 'cmd'
			Enumeration en = request.getParameterNames();
			String str = "cmd=_notify-validate";
			while (en.hasMoreElements()) {
				String paramName = (String) en.nextElement();
				String paramValue = request.getParameter(paramName);
				str =
					str + "&" + paramName + "=" + URLEncoder.encode(paramValue);
			}

			//	post back to PayPal system to validate
			//	NOTE: change http: to https: in the following URL to verify using SSL (for increased security).
			//	using HTTPS requires either Java 1.4 or greater, or Java Secure Socket Extension (JSSE)
			//	and configured for older versions.
			URL u = new URL("http://www.paypal.com/cgi-bin/webscr");
			URLConnection uc = u.openConnection();
			uc.setDoOutput(true);
			uc.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			PrintWriter pw = new PrintWriter(uc.getOutputStream());
			pw.println(str);
			pw.close();

			BufferedReader in =
				new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String res = in.readLine();
			in.close();

			//			   assign posted variables to local variables
			int cartQuantity =
				Integer.parseInt(request.getParameter("num_cart_items"));
			String itemName = "";
			String itemNumber = "";
			String itemQuantity = "";
			String sep = "";
			for (int i = 0; i < cartQuantity; i++) {
				itemName += sep + (request.getParameter("item_name" + (i + 1)));
				itemNumber += sep
					+ (request.getParameter("item_number" + (i + 1)));
				itemQuantity += sep
					+ (request.getParameter("quantity" + (i + 1)));
				sep = ";";
			}
			String paymentStatus = request.getParameter("payment_status");
			String custom = request.getParameter("custom");
			String invoice = request.getParameter("invoice");
			String paymentAmount = request.getParameter("mc_gross");
			String paymentCurrency = request.getParameter("mc_currency");
			String txnId = request.getParameter("txn_id");
			String receiverEmail = request.getParameter("receiver_email");
			String payerEmail = request.getParameter("payer_email");
			String paymentDate = request.getParameter("payment_date");
			String pendingReason = request.getParameter("pending_reason");
			String mcgross = request.getParameter("mc_gross");

			//check notification validation
			if (res.equals("VERIFIED")) {
				PreparedStatement selectSt =
					cn.prepareStatement(
						"SELECT * FROM payments WHERE txnid = ?");
				selectSt.setString(1, txnId);
				ResultSet rs = selectSt.executeQuery();
				if (rs.next()) {
					if (paymentStatus.equals("Pending")) {
						PreparedStatement pendingSt =
							cn.prepareStatement(
								"UPDATE payments SET pendingreason=? WHERE txnid=?");
						pendingSt.setString(1, pendingReason);
						pendingSt.setString(2, txnId);
					}
					else if (paymentStatus.equals("Completed")) {
						if (rs.getString("paymentstatus").equals("Pending")) {
							// First time it is completed!
							PreparedStatement st =
								cn.prepareStatement(
									"UPDATE payments SET pendingreason=?, paymentstatus=? WHERE txnid=?");
							st.setString(1, "Completed");
							st.setString(2, "Completed");
							st.setString(3, txnId);
							st.executeUpdate();
							// Let the user have the points he bought
							st =
								cn.prepareStatement(
									"UPDATE user SET points=points+? WHERE id=?");
							st.setString(1, rs.getString("points"));
							st.setString(2, custom);
							st.executeUpdate();
						}
					}
					else if (paymentStatus.equals("Failed")) {
						PreparedStatement st =
							cn.prepareStatement(
								"UPDATE payments SET paymentstatus=? WHERE txnid=?");
						st.setString(1, paymentStatus);
						st.setString(2, txnId);
					}
					else if (paymentStatus.equals("Denied")) {
						PreparedStatement st =
							cn.prepareStatement(
								"UPDATE payments SET paymentstatus=? WHERE txnid=?");
						st.setString(1, paymentStatus);
						st.setString(2, txnId);
					}
					else if (paymentStatus.equals("Refunded")) {
						PreparedStatement st =
							cn.prepareStatement(
								"UPDATE payments SET paymentstatus=? WHERE txnid=?");
						st.setString(1, paymentStatus);
						st.setString(2, txnId);
					}
					else if (paymentStatus.equals("Canceled")) {
						PreparedStatement st =
							cn.prepareStatement(
								"UPDATE payments SET paymentstatus=? WHERE txnid=?");
						st.setString(1, paymentStatus);
						st.setString(2, txnId);
					}
				}
				else {
					// New payment
					// Check the invoice of the payment against the id in our DB
					PreparedStatement st =
						cn.prepareStatement(
							"SELECT * FROM pendingpayments WHERE id=?");
					st.setString(1, invoice);
					ResultSet rs2 = st.executeQuery();
					if (rs2.next()) {
						// The payment is there - now let's check the data with the records
						boolean test = true;
						String reason = "";
						if (!itemName.equals(rs.getString("items"))) {
							test = false;
							reason += "Item Names did not match: "
								+ itemName
								+ " vs. "
								+ rs.getString("items");
						}
						if (!itemNumber.equals(rs.getString("itemnumbers"))) {
							test = false;
							reason += "Item Numbers did not match: "
								+ itemNumber
								+ " vs. "
								+ rs.getString("itemnumbers");
						}
						if (!itemQuantity.equals(rs.getString("quantities"))) {
							test = false;
							reason += "Item Quantities did not match: "
								+ itemQuantity
								+ " vs. "
								+ rs.getString("quantities");
						}
						if (!custom.equals(rs.getString("userid"))) {
							test = false;
							reason += "User ID did not match: "
								+ custom
								+ " vs. "
								+ rs.getString("userid");
						}
						if (test) {
							// okay, the payment passed the test... we can insert it into the payments table
							PreparedStatement ps3 =
								cn.prepareStatement(
									"INSERT INTO payments (txnid, custom, itemname, itemnumber, itemquantity, paymentstatus, pendingreason, payeremail, invoice, receiveremail, paymentdate, points) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
							ps3.setString(1, txnId);
							ps3.setString(2, custom);
							ps3.setString(3, itemName);
							ps3.setString(4, itemNumber);
							ps3.setString(5, itemQuantity);
							ps3.setString(6, paymentStatus);
							ps3.setString(7, pendingReason);
							ps3.setString(8, payerEmail);
							ps3.setString(9, invoice);
							ps3.setString(10, receiverEmail);
							ps3.setString(11, paymentDate);
							ps3.setString(12, rs.getString("points"));
							if (paymentStatus.equals("Completed")) {

								// First time it is completed!

								// Let the user have the points he bought
								st =
									cn.prepareStatement(
										"UPDATE user SET points=points+? WHERE id=?");
								st.setString(1, rs.getString("points"));
								st.setString(2, custom);
								st.executeUpdate();
							}
						}
						else {
							// the payment did not pass the tests....
							this.logFile.seek(logFile.length());
							this.logFile.writeChars(
								"\nAn payment did not pass the tests....!");
							this.logFile.writeChars(
								"\n" + txnId + " " + custom + " " + reason);
						}
					}
					else {
						this.logFile.seek(logFile.length());
						this.logFile.writeChars(
							"\nAn payment not set in the software was received....!");
						this.logFile.writeChars("\n" + txnId + " " + custom);
					}

				}
			}
			else if (res.equals("INVALID")) {
				this.logFile.seek(logFile.length());
				this.logFile.writeChars(
					"\nAn invalid request was returned from PayPal!");
				this.logFile.writeChars("\n" + txnId + " " + custom);
			}
			else {
				this.logFile.seek(logFile.length());
				this.logFile.writeChars(
					"\nAn error occured while processing a request in the Servlet!");
			}
		}
		catch (Exception e) {
			this.logFile.seek(logFile.length());
			this.logFile.writeChars(e.toString());
		}
	}
}