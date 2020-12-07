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
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailInput=request.getParameter("inputEmailCli");
		String pwdInput=request.getParameter("inputPwdCli");
		
	
		Client client=ClientDaoOperations.checkDB(emailInput, pwdInput);
			if(client.getEmailCli() != null ) {
				HttpSession session=request.getSession(true);
				session.setAttribute("numClient", client.getNumCli());
				session.setAttribute("prenomClient", client.getPrenomCli());
				session.setAttribute("nomClient", client.getNomCli());
				session.setAttribute("adresseClient", client.getAdresseCli());
				session.setAttribute("phoneClient",client.getTelCli() );
				session.setAttribute("villeClient",client.getVilleCli() );				
				session.setAttribute("emailCli", client.getVilleCli() );
				session.setAttribute("pwdCli", client.getPasswordCli() );
				
				//request.getRequestDispatcher("Annuite.jsp").forward(request, response);
				response.sendRedirect("Annuite.jsp");

			}else {
				response.sendRedirect("Inscription.jsp");

			}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
