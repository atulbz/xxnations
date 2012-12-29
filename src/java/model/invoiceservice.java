/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Shaishav
 */
public class invoiceservice {

    String classname,driver;
    
    public invoiceservice(String classname,String driver) {
          this.classname = classname;
           this.driver = driver;
    }
    
    
    public int addInvoice(int user_id,long invoice_number,float amount)
    {
        invoicedao obj=new invoicedao(classname,driver);
        return obj.addInvoicedao(user_id, invoice_number,amount);
    }
    
    public int getInvoice(int user_id,long invoice_number,float amount)
    {
        invoicedao obj=new invoicedao(classname,driver);
        return obj.getInvoicedao(user_id, invoice_number, amount);
    }
    
     public int removeInvoice(int user_id,long invoice_number,float amount)
    {
        invoicedao obj=new invoicedao(classname,driver);
        return obj.removeInvoicedao(user_id, invoice_number, amount);
    }
}
