package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;

import com.beans.Artisan;
import com.beans.Client;
import com.beans.Transaction;
import com.dao.ArtisanDao;
import com.dao.ClientDao;
import com.dao.DAOFactory;
import com.dao.TransactionDao;

@WebServlet("/PageArtisan")
public class PageArtisan extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArtisanDao artisanDao;
    
    
    private ClientDao clientDao;
	 private TransactionDao transactionDao;
	
    public void init() throws ServletException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		this.artisanDao=daoFactory.getArtisanDao();
		this.clientDao=daoFactory.getClientDao();
		this.transactionDao=daoFactory.getTransactionDao();} 
	

  
    public PageArtisan() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("username").toString();
		
		Artisan a = artisanDao.trouverUsername(username);
		request.setAttribute("a", a); 
		HttpSession session =request.getSession();
		session.setAttribute("artUser", username);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/pageArtisan.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession msession =request.getSession();
		String username=(String)msession.getAttribute("artUser");

         
		
		Artisan a = artisanDao.trouverUsername(username); 
		request.setAttribute("a", a);
		HttpSession session = request.getSession();
		Client c= clientDao.trouverUsername(session.getAttribute("user").toString());
		String action = request.getParameter("action");
		String message=request.getParameter("message");
		Transaction transaction = new Transaction();
		transaction.setClient(c);
	     
	     transaction.setArtisan(a);
	    
	     transaction.setMessage(message);
		
		

		if ("Contacter".equals(action)) {
		  
	     transaction.setDate( new DateTime() );
	        
	   
	        transactionDao.creer(transaction);}
		this.getServletContext().getRequestDispatcher("/WEB-INF/pageArtisan.jsp").forward(request, response);
	}

}
