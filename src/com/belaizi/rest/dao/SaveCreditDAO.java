package com.belaizi.rest.dao;

import java.sql.SQLException;

import com.belaizi.rest.model.Credit;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class SaveCreditDAO {
	
	public static void saveDB(Credit cr)
	{
		Connection con = null;
		PreparedStatement pdStatement = null;
		try {
			 con = ConnexionDB.createConnection();
			 pdStatement = con.prepareStatement("INSERT INTO credit(numCre,dateCre,dureeCre,tauxCre,annuiteCre,capitalCre,numClient) values (NULL,?,?,?,?,?,?)"); //Making use of prepared statements here to insert bunch of data
			 pdStatement.setString(1,cr.getDateCre() );
			 pdStatement.setInt(2, cr.getDureeCre());
			 pdStatement.setDouble(3, cr.getTauxCre());
			 pdStatement.setDouble(4, cr.getAnnuiteCre());
			 pdStatement.setDouble(5, cr.getCapitalCre());
			 pdStatement.setInt(6, cr.getNumClient());
			 
			 pdStatement.execute();
		}catch(SQLException ex ) {
			 ex.printStackTrace();

		}
	}
}
