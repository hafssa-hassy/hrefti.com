package com.servlets;

import java.io.BufferedInputStream;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Artisan;
import com.dao.ArtisanDao;
import com.dao.ArtisanDaoImpl;
import com.dao.DAOFactory;
/**
 * Servlet implementation class Recherche
 */
@WebServlet("/Recherche")
public class Recherche extends HttpServlet {
	  private static final long serialVersionUID = 1L;
	  private ArtisanDao artisanDao;
	 
	public void init() throws ServletException{
		DAOFactory daoFactory = DAOFactory.getInstance();
		this.artisanDao=daoFactory.getArtisanDao();
	}
	
	  
    public Recherche() {
        super();
        // TODO Auto-generated constructor stub
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
        
		this.getServletContext().getRequestDispatcher("/WEB-INF/Brecherche.jsp").forward(request, response);
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		

		
		HttpSession session =request.getSession();
		String Rech=request.getParameter("search");
		
		Artisan artisan =artisanDao.trouverNom(Rech);
        request.setAttribute("Rech", Rech);
        String Countrow=artisanDao.count(Rech);
        request.setAttribute("Countrow", Countrow);
        request.setAttribute("artisan", artisan);
        
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Brecherche.jsp").forward(request, response);
		
	}

}
