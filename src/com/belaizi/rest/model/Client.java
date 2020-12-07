package com.belaizi.rest.model;

import java.io.Serializable;

public class Client implements Serializable  {
	 
	private int numCli;
	private String nomCli;
	private String prenomCli;
	private String adresseCli;
	private String villeCli;
	private int telCli;
	private String emailCli;
	private String passwordCli;

	
	public int getNumCli() {
		return numCli;
	}
	public void setNumCli(int numCli) {
		this.numCli = numCli;
	}
	public String getNomCli() {
		return nomCli;
	}
	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}
	public String getPrenomCli() {
		return prenomCli;
	}
	public void setPrenomCli(String prenomCli) {
		this.prenomCli = prenomCli;
	}
	public String getAdresseCli() {
		return adresseCli;
	}
	public void setAdresseCli(String adresseCli) {
		this.adresseCli = adresseCli;
	}
	public String getVilleCli() {
		return villeCli;
	}
	public void setVilleCli(String villeCli) {
		this.villeCli = villeCli;
	}
	public int getTelCli() {
		return telCli;
	}
	public void setTelCli(int telCli) {
		this.telCli = telCli;
	}
	public String getEmailCli() {
		return emailCli;
	}
	public void setEmailCli(String emailCli) {
		this.emailCli = emailCli;
	}
	@Override
	public String toString() {
		return "Client [numCli=" + numCli + ", nomCli=" + nomCli + ", prenomCli=" + prenomCli + ", adresseCli="
				+ adresseCli + ", villeCli=" + villeCli + ", telCli=" + telCli + ", emailCli=" + emailCli
				+ ", passwordCli=" + passwordCli + "]";
	}
	public String getPasswordCli() {
		return passwordCli;
	}
	public void setPasswordCli(String passwordCli) {
		this.passwordCli = passwordCli;
	}
	
	


    
}
