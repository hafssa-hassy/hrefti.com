package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Artisan;
import com.beans.Client;
import com.beans.Transaction;
import com.dao.ArtisanDao;
import com.dao.ClientDao;
import com.dao.DAOFactory;
import com.dao.TransactionDao;


/**
 * Servlet implementation class BoiteArtisan
 */
@WebServlet("/BoiteArtisan")
public class BoiteArtisan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TransactionDao transactionDao;
	private ArtisanDao artisanDao;
	private ClientDao clientDao;
	
	public void init() throws ServletException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		this.transactionDao=daoFactory.getTransactionDao();
		this.clientDao=daoFactory.getClientDao();
		this.artisanDao=daoFactory.getArtisanDao();
		}
    public BoiteArtisan() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		String username=(String) session.getAttribute("user");	
		Artisan a =artisanDao.trouverUsername(username);
		
		List<Transaction> transactions = transactionDao.lister(a.getCIN());
		 request.setAttribute("transactions", transactions);
			
		 for(Transaction transaction : transactions) {
			 
			 Client client = transaction.getClient();
			 request.setAttribute("client", client);
		 }
		
		 
		 
		 
		this.getServletContext().getRequestDispatcher("/WEB-INF/BoiteArtisan.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		


		
		HttpSession session =request.getSession();
		String username=(String) session.getAttribute("user");	
		Artisan a =artisanDao.trouverUsername(username);
		List<Transaction> transactions = transactionDao.lister(a.getCIN());
		

		
		 request.setAttribute("transactions", transactions);
		
		 for(Transaction transaction : transactions) {
			 
			 Client client = transaction.getClient();
			 request.setAttribute("client", client);
		 }
		
		 
		/*
		 * if (valider.equals("buttonVa")) { String
		 * clientuser=request.getParameter("bt"); Client
		 * c=clientDao.trouverUsername(clientuser);
		 * transactionDao.validation(a.getCIN(),c.getCINc());}
		 */
		 String Justification=request.getParameter("justification");
		// if (request.getParameter("Envoyer") != null) {		 
		// transactionDao.insertion(Justification, a.getCIN(),c.getCINc());
		// }
		 
			
		
		 
		this.getServletContext().getRequestDispatcher("/WEB-INF/BoiteArtisan.jsp").forward(request, response);
		  
	}

}
