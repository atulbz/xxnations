/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import view.DatasourceConnection;

/**
 * Web application lifecycle listener.
 * @author Shaishav
 */
public class WebApplicationListener implements ServletContextListener {

    
    public void contextInitialized(ServletContextEvent sce) {
        
        ServletContext sc=sce.getServletContext();
        String classname=(String)sc.getInitParameter("classname");
        String driver=(String)sc.getInitParameter("driver");
        System.out.println("Classname "+classname);
        System.out.println("Driver "+driver);
        DatasourceConnection.initDatasource();
        
        
        
    }

    
    public void contextDestroyed(ServletContextEvent sce) {
        DatasourceConnection.closeDatasource();
    }
}
