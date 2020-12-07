package com.belaizi.rest.controller;

import java.io.IOException;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jettison.json.JSONObject;

import com.belaizi.rest.client.AnnuiteRestClient;
import com.belaizi.rest.dao.SaveCreditDAO;
import com.belaizi.rest.model.Credit;
import com.belaizi.rest.model.CreditModel;
import com.belaizi.rest.ws.Services;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * Servlet implementation class AnnuiteServlet
 */
@WebServlet("/AnnuiteServlet")
public class AnnuiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnuiteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		   HttpSession session = request.getSession();
   	       DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		   Date d = new Date();
		   String date = dateFormat.format(d);		
	       Credit credit =new Credit();
           		   
   		   String urlCapital =request.getParameter("inputCapital");
   		   String urlDuree =request.getParameter("inputDuree");
   		   String urlTaux =request.getParameter("inputTaux");

   		   if(request.getParameter("inputCapital") != null && request.getParameter("inputCapital") != null && request.getParameter("inputTaux")  != null) {
   			 
		   		   AnnuiteRestClient annuiteRestClient= new AnnuiteRestClient();
		   		   CreditModel creditModel =annuiteRestClient.getAnnuite(urlCapital, urlDuree, urlTaux);
		
		       		
		       	   session.setAttribute("capitalResA", creditModel.getCapitalCre());
		       	   session.setAttribute("dureeResA", creditModel.getDureeCre());
		       	   session.setAttribute("tauxResA", creditModel.getTauxCre());
		       	   session.setAttribute("annuiteResA", creditModel.getAnnuiteCre());
		    	
		
		       	   int numeroClient = ((Integer)session.getAttribute("numClient")).intValue();
		
		 		   credit.setAnnuiteCre(creditModel.getAnnuiteCre());
		 		   credit.setDureeCre(creditModel.getDureeCre());
		 		   credit.setCapitalCre(creditModel.getCapitalCre());
		 		   credit.setTauxCre(creditModel.getTauxCre());
		
		 		   credit.setDateCre(date);
		 		   credit.setNumClient(numeroClient);
		 			
		 		   SaveCreditDAO.saveDB(credit);

   		   }
   		   
           request.getRequestDispatcher("Annuite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
