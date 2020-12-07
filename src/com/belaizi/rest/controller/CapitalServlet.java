package com.belaizi.rest.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.belaizi.rest.client.AnnuiteRestClient;
import com.belaizi.rest.dao.SaveCreditDAO;
import com.belaizi.rest.model.Credit;
import com.belaizi.rest.model.CreditModel;


/**
 * Servlet implementation class CapitalServlet
 */
@WebServlet("/CapitalServlet")
public class CapitalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapitalServlet() {
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
        
        String urlAnnuite =request.getParameter("inputAnnuite");
		String urlDuree =request.getParameter("inputDuree");
		String urlTaux =request.getParameter("inputTaux");
		
	    if(request.getParameter("inputAnnuite") != null && request.getParameter("inputDuree") != null && request.getParameter("inputTaux")  != null) {

		    AnnuiteRestClient annuiteRestClient= new AnnuiteRestClient();
		   	CreditModel creditModel =annuiteRestClient.getCapital(urlAnnuite, urlDuree, urlTaux);
		   	
		   	session.setAttribute("capitalResC", creditModel.getCapitalCre());
		   	session.setAttribute("dureeResC", creditModel.getDureeCre());
		   	session.setAttribute("tauxResC", creditModel.getTauxCre());
		   	session.setAttribute("annuiteResC", creditModel.getAnnuiteCre());
   		
	        
		   	int numeroClient = ((Integer)session.getAttribute("numClient")).intValue();
	
		    credit.setAnnuiteCre(creditModel.getAnnuiteCre());
	 		credit.setDureeCre(creditModel.getDureeCre());
	 		credit.setCapitalCre(creditModel.getCapitalCre());
	 		credit.setTauxCre(creditModel.getTauxCre());
		   
	 		credit.setDateCre(date);
		    credit.setNumClient(numeroClient);
			
		    SaveCreditDAO.saveDB(credit);
			
	    }	
	    
   		response.sendRedirect("Capital.jsp");
  	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
