package com.belaizi.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CreditModel") 
public class CreditModel {
	
	private int dureeCre;
	private double tauxCre;
	private double annuiteCre;
	private double capitalCre;
	
	public CreditModel() {
		
	}
	public CreditModel(int dureeCre, double tauxCre, double annuiteCre, double capitalCre) {
		this.dureeCre = dureeCre;
		this.tauxCre = tauxCre;
		this.annuiteCre = annuiteCre;
		this.capitalCre = capitalCre;
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
	@Override
	public String toString() {
		return "CreditModel [dureeCre=" + dureeCre + ", tauxCre=" + tauxCre + ", annuiteCre=" + annuiteCre
				+ ", capitalCre=" + capitalCre + "]";
	}

	
	
}
