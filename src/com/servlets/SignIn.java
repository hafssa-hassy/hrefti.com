package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Artisan;
import com.beans.Client;

import com.dao.ArtisanDao;

import com.dao.ClientDao;
import com.dao.DAOFactory;




@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArtisanDao artisanDao;
	private ClientDao clientDao;
    
	
	public void init() throws ServletException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		this.artisanDao=daoFactory.getArtisanDao();
		this.clientDao=daoFactory.getClientDao();
		
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login=request.getParameter("username"); //on met entre "" ce qui est dans l'attribut name 
		String password=request.getParameter("psw");
		String userType2;
		HttpSession session =request.getSession();
		Artisan a =artisanDao.trouverArtisan(login, password);
		if(a==null) {
				Client c = clientDao.trouverClient(login, password);
				if(c==null) {
					
					String message= "Utilisateur non existant,veuillez vérifier votre nom et mot de passe";
					request.setAttribute("error", message);
					this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
					
				}
				else {
					userType2="c";
					session.setAttribute("user", login);
					
					session.setAttribute("userType2", userType2);
					this.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
				}
				
		}
		else {

			userType2="a";
			session.setAttribute("user", login);
			session.setAttribute("userType2", userType2);
			String image=a.getImage();
			session.setAttribute("image", image);
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
		}					
		

		
			
			
	}

}
