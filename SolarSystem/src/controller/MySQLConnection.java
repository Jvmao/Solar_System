package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class MySQLConnection {
	//Variables
	private String host; 
	private String db; 
	private String user; 
	private String pass; 
	private static Connection conn = null;
	public static MySQLConnection SQLConn = null;

	
	public boolean MySQLDB() throws ClassNotFoundException {
		host="localhost";
		db="SolarSystem?serverTimezone=";
		user="root";
		pass="";
		
		try {
			//Connection to DB
			//jdbc:mysql://127.0.0.1/db?serverTimezone="+TimeZone.getDefault().getID()
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://"+this.host+"/"+this.db+TimeZone.getDefault().getID(), this.user, this.pass);
	        System.out.println("Connecting...");
	        if (conn != null) {
	            DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
	            System.out.println("Driver name: " + dm.getDriverName());
	            System.out.println("Driver version: " + dm.getDriverVersion());
	            System.out.println("Product name: " + dm.getDatabaseProductName());
	            System.out.println("Product version: " + dm.getDatabaseProductVersion());
	        }
		}catch (SQLException exSQL){
			exSQL.printStackTrace();
		}finally {
			try {
                if (conn != null && !conn.isClosed()) {
                    //conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
		}
		return false;
	}
	
	public static Connection getConnection() {
		if(conn==null) {
			SQLConn = new MySQLConnection();
		}return conn;
	}
	

}
