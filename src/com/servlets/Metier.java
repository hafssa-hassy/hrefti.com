package com.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ArtisanDao;
import com.dao.DAOFactory;
import com.beans.Artisan;

import java.util.Properties;



@WebServlet("/Metier")
public class Metier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArtisanDao artisanDao;
	
	public void init() throws ServletException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		this.artisanDao=daoFactory.getArtisanDao();}
	

    public Metier() {
        super();
        
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type= request.getParameter("type").toString();
		String jsp="/WEB-INF/"+type+"s"+".jsp";
		
		InputStream in = Metier.class.getClassLoader().getResourceAsStream("config.properties");
		Properties prop= new Properties () ;
		prop.load(in);
		String urlEchantillons=prop.getProperty( "urlEchantillons" );
		
		
		List<Artisan> artisans = artisanDao.lister(type);
		List<List<String>> imageList=new ArrayList<List<String>>();
		
		for(Artisan artisan : artisans) {
			
		
			List<String> imageUrlList = new ArrayList<String>(); 

		
			File imageDir = new File(urlEchantillons+artisan.getDossEchantillons());  
			for(File imageFile : imageDir.listFiles()){  
				String imageFileName = imageFile.getName();  

		  
				imageUrlList.add(imageFileName);  

		}
			
		imageList.add(imageUrlList);
		}
	
		
		
		request.setAttribute("artisans", artisans); 
     	request.setAttribute("imageList", imageList);
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("user");
		if(  username!=null ) {
			this.getServletContext().getRequestDispatcher(jsp).forward(request,response);
		}
		else {
			boolean testInscrit=false;
			request.setAttribute("testInscrit",testInscrit);
			this.getServletContext().getRequestDispatcher("/WEB-INF/inscriptionChoix.jsp").forward(request,response);
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
