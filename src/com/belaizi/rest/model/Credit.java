package com.belaizi.rest.model;

import java.io.Serializable;

public class Credit implements Serializable  {
	
	private int numCre;
	private String dateCre;
	private int dureeCre;
	private double tauxCre;
	private double annuiteCre;
	private double capitalCre;
	private int numClient;
	
	
	public int getNumCre() {
		return numCre;
	}
	public void setNumCre(int numCre) {
		this.numCre = numCre;
	}
	public String getDateCre() {
		return dateCre;
	}
	public void setDateCre(String dateCre) {
		this.dateCre = dateCre;
	}
	public int getDureeCre() {
		return dureeCre;
	}
	public void setDureeCre(int dureeCre) {
		this.dureeCre = dureeCre;
	}
	public double getTauxCre() {
		return tauxCre;
	}
	public void setTauxCre(double tauxCre) {
		this.tauxCre = tauxCre;
	}
	public double getAnnuiteCre() {
		return annuiteCre;
	}
	public void setAnnuiteCre(double annuiteCre) {
		this.annuiteCre = annuiteCre;
	}
	public double getCapitalCre() {
		return capitalCre;
	}
	public void setCapitalCre(double capitalCre) {
		this.capitalCre = capitalCre;
	}
	public int getNumClient() {
		return numClient;
	}
	public void setNumClient(int numClient) {
		this.numClient = numClient;
	}
	@Override
	public String toString() {
		return "Credit [numero de credit=" + numCre + ", date de  Credit=" + dateCre + ", duree=" + dureeCre + ", taux=" + tauxCre
				+ ", annuite=" + annuiteCre + ", capital=" + capitalCre + ", numero de Client=" + numClient + "]";
	}
	
	
    
}
