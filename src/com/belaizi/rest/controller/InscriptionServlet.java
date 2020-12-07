package com.belaizi.rest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.belaizi.rest.dao.ClientDaoOperations;
import com.belaizi.rest.model.Client;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Client c=new Client();
		c.setNomCli(request.getParameter("inputNomCli"));
		c.setPrenomCli(request.getParameter("inputPrenomCli"));
		c.setAdresseCli(request.getParameter("inputAdresseCli"));
        c.setVilleCli(request.getParameter("inputVilleCli"));
        c.setTelCli(Integer.parseInt(  request.getParameter("inputTelCli")));
        c.setEmailCli(request.getParameter("inputEmailCli"));
        c.setPasswordCli(request.getParameter("inputPwdCli"));
        
        ClientDaoOperations.saveDB(c);
		HttpSession session = request.getSession(true);
        response.sendRedirect("Connexion.jsp");
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
