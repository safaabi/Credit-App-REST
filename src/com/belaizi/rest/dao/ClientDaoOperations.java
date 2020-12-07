package com.belaizi.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.belaizi.rest.model.Client;

public class ClientDaoOperations {
	public static void saveDB(Client cl)	{
		Connection con = null;
		PreparedStatement pdStatement = null;
		try {
			 con = ConnexionDB.createConnection();
			 pdStatement = con.prepareStatement("INSERT INTO client(numCli,nomCli,prenomCli,adresseCli,villeCli,telCli,emailCli,passwordCli) values (NULL,?,?,?,?,?,?,?)");
			 pdStatement.setString(1, cl.getNomCli());
			 pdStatement.setString(2, cl.getPrenomCli());
			 pdStatement.setString(3, cl.getAdresseCli());
			 pdStatement.setString(4, cl.getVilleCli());
			 pdStatement.setInt(5, cl.getTelCli());
			 pdStatement.setString(6, cl.getEmailCli());
			 pdStatement.setString(7, cl.getPasswordCli());

			int status= pdStatement.executeUpdate();
		}catch(SQLException ex ) {
			 ex.printStackTrace();

		}
	}
	public static Client checkDB(String emailInput,String passwordInput){
		Connection con = null;
		Statement statement = null;
		ResultSet rs=null;
		Boolean status =false;
		Client client= new Client();;
		
		try {
			con = ConnexionDB.createConnection();

			statement = con.createStatement();
			rs = statement.executeQuery("select * from client");
            while (rs.next()) {
				if (emailInput.equals(rs.getString("emailCli")) && passwordInput.equals(rs.getString("passwordCli"))) {
					client.setNumCli(rs.getInt("numCli"));
					client.setPrenomCli(rs.getString("prenomCli"));
					client.setNomCli(rs.getString("nomCli"));
					client.setAdresseCli(rs.getString("adresseCli"));
					client.setTelCli(rs.getInt("telCli"));
					client.setVilleCli(rs.getString("villeCli"));
					client.setEmailCli(rs.getString("emailCli"));
					client.setPasswordCli(rs.getString("passwordCli"));
					
					System.out.println(client);
				}else{
					System.out.println("Erreur de connexion");
		        }
		   }
		}catch(SQLException ex ) {
			 ex.printStackTrace();

		}
		return client;		
	}
	
}
