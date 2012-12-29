/*
 * DatasourceConnection.java
 *
 * Created on March 25, 2012, 12:08 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package view;

import java.sql.Connection;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public class DatasourceConnection {

    private static DataSource datasource = null;

    DatasourceConnection() {
    }

    public static Connection getConnection() {
        try {
            if (datasource == null) {
                DatasourceConnection.initDatasource();
            }
            return datasource.getConnection();
        } 
        
        catch (Exception e) {
           // return DatasourceConnection.initDatasource();
            return null;
        }
    }

    public static void initDatasource() {

        PoolProperties p = new PoolProperties();

        p.setUrl("jdbc:mysql://localhost:3306/xxnation_music");
        p.setDriverClassName("com.mysql.jdbc.Driver");
        p.setUsername("root");
        p.setPassword("");

        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);

        p.setMaxActive(175);
        p.setMaxIdle(175);
        p.setInitialSize(10);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);

        p.setLogAbandoned(true);		
        p.setRemoveAbandoned(true);

        p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
                + "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");

        datasource = new DataSource();
        datasource.setPoolProperties(p);

    }

    public static void closeDatasource() {
        datasource.close();
    }
    
    public static void closeConnection(Connection con)
    {
        try {
				con.close();
			} 
        catch (Exception e) {
				e.printStackTrace();
			}

    }
}