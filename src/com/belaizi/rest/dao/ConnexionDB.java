package com.belaizi.rest.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class ConnexionDB {

     public static Connection createConnection() {
    	 Connection con=null;
    	 try {   		 
    		 Class.forName("com.mysql.jdbc.Driver");
    		 con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioncredit", "root", "");

    	 }catch(Exception ex) {
 			ex.printStackTrace();
    	 }
    	 return con;
     }
     
}


