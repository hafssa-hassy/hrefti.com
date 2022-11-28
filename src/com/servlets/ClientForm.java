package com.servlets;

import java.io.IOException;



import java.time.format.DateTimeFormatter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Client;

import com.dao.ClientDao;
import com.dao.DAOFactory;
import com.forms.Clientsignupform;


@WebServlet("/ClientForm")
public class ClientForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ClientForm() {
        super();
       
    }
    
    
    private ClientDao clientDao;
    public void init() throws ServletException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		this.clientDao=daoFactory.getClientDao();
		
	}
    
    
    
    public static final String ATT_CLIENT = "client";
    public static final String ATT_FORM   = "clientform";

    public static final String VUE_SUCCES = "/WEB-INF/login.jsp";
    public static final String VUE_FORM   = "/WEB-INF/signupClient.jsp";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String userType="c";
        HttpSession session = request.getSession();

        session.setAttribute("userType", userType); 
		
		
		// Préparation de l'objet formulaire 
        Clientsignupform form = new Clientsignupform();

        // Traitement de la requête et récupération du bean en résultant 
       Client client = form.verifierClient( request ); 
  
        // Ajout du bean et de l'objet métier à l'objet requête 
        request.setAttribute( ATT_CLIENT, client );
        request.setAttribute( ATT_FORM, form );
    	
        
        
        if ( form.getErreurs().isEmpty() ) {
        	//stockage du client dans la  base de données
        	

        	clientDao.creer(client);
            // Si aucune erreur, alors affichage du login
        	   
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            // Sinon, ré-affichage du formulaire de création avec les erreurs 
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }

	}

}
