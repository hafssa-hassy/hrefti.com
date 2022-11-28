package com.servlets;

import java.io.BufferedInputStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.beans.Artisan;
import com.dao.ArtisanDao;
import com.dao.DAOFactory;


/**
 * Servlet implementation class ProfilArtisan
 */
@WebServlet("/ProfilArtisan")
@MultipartConfig( location= "C:/fichiertemp",
fileSizeThreshold = 1048576, 
maxFileSize = 52428800,
maxRequestSize = 52428800)
public class ProfilArtisan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static final int TAILLE_TAMPON = 10240;
	
	 private ArtisanDao artisanDao;
	
	
	public void init() throws ServletException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		this.artisanDao=daoFactory.getArtisanDao();} 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilArtisan() {
        super();
        // TODO Auto-generated constructor stub
    }
    public static final String ATT_ARTISAN = "artisan";
    public static final String ATT_FORM   = "artisanform";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession();
		String username=(String) session.getAttribute("user");	
		Artisan a =artisanDao.trouverUsername(username);
		request.setAttribute("a", a); 
		
	  this.getServletContext().getRequestDispatcher("/WEB-INF/profilArtisan.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 InputStream in =ProfilArtisan.class.getClassLoader().getResourceAsStream("config.properties");
			Properties prop= new Properties () ;
			prop.load(in);
		
		String CHEMIN_TRAVAUX =prop.getProperty( "urlEchantillons" );
		String CHEMIN_IMAGES = prop.getProperty( "urlImagesArtisans" );
		
		HttpSession session =request.getSession();
		String username=(String) session.getAttribute("user");	
		
		Artisan a =artisanDao.trouverUsername(username);
		//request.setAttribute("a", a); 
		
		String experience=request.getParameter("experience");
		a.setExperience(experience);
		
				// On r�cup�re le champ du fichier
		        Part part1 = request.getPart("tra1");
		        Part part2 = request.getPart("tra2");
		        Part part3 = request.getPart("tra3");
		        Part part4 = request.getPart("tra4");
		        Part part = request.getPart("local");
		     // On v�rifie qu'on a bien re�u un fichier
		        //String tra0 = getNomFichier(part0);
		        String tra1 = getNomFichier(part1);
		        String tra2 = getNomFichier(part2);
		        String tra3 = getNomFichier(part3);
		        String tra4 = getNomFichier(part4);
		        String local=getNomFichier(part);
		     // Si on a bien un fichier
		        
		
		        
		        if (tra1 != null && !tra1.isEmpty()) {
		            String nomChamp1 = part1.getName();
		            // Corrige un bug du fonctionnement d'Internet Explorer
		            tra1 = tra1.substring(tra1.lastIndexOf('/') + 1)
		                    .substring(tra1.lastIndexOf('\\') + 1);

		            // On écrit définitivement le fichier sur le disque
		            ecrireFichier(part1, tra1, CHEMIN_TRAVAUX+a.getDossEchantillons()+"/");

		            request.setAttribute(nomChamp1, tra1);
		        }
			        
		        if (tra2 != null && !tra2.isEmpty()) {
		            String nomChamp2 = part2.getName();
		            // Corrige un bug du fonctionnement d'Internet Explorer
		            tra2 = tra2.substring(tra2.lastIndexOf('/') + 1)
		                    .substring(tra2.lastIndexOf('\\') + 1);

		            // On écrit définitivement le fichier sur le disque
		            ecrireFichier(part2, tra2, CHEMIN_TRAVAUX+a.getDossEchantillons()+"/");

		            request.setAttribute(nomChamp2, tra2);
		        }
			        
		        if (tra3 != null && !tra3.isEmpty()) {
		            String nomChamp3 = part3.getName();
		            // Corrige un bug du fonctionnement d'Internet Explorer
		            tra3 = tra3.substring(tra3.lastIndexOf('/') + 1)
		                    .substring(tra3.lastIndexOf('\\') + 1);

		            // On écrit définitivement le fichier sur le disque
		            ecrireFichier(part3, tra3, CHEMIN_TRAVAUX+a.getDossEchantillons()+"/");

		            request.setAttribute(nomChamp3, tra3);
		        }
			        
		        if (tra4 != null && !tra4.isEmpty()) {
		            String nomChamp4 = part4.getName();
		            // Corrige un bug du fonctionnement d'Internet Explorer
		            tra1 = tra1.substring(tra1.lastIndexOf('/') + 1)
		                    .substring(tra1.lastIndexOf('\\') + 1);

		            // On écrit définitivement le fichier sur le disque
		            ecrireFichier(part4, tra4, CHEMIN_TRAVAUX+a.getDossEchantillons()+"/");

		            request.setAttribute(nomChamp4, tra4);
		        }
		        if (local != null && !local.isEmpty()) {
		            String nomChamp = part.getName();
		            // Corrige un bug du fonctionnement d'Internet Explorer
		            local = local.substring(local.lastIndexOf('/') + 1)
		                    .substring(local.lastIndexOf('\\') + 1);

		            // On écrit définitivement le fichier sur le disque
		            ecrireFichier(part, local, CHEMIN_IMAGES);

		            request.setAttribute(nomChamp, local);
		        } 
		        request.setAttribute("experience", experience);
		        
		        
		        artisanDao.ajouter(experience,a.getCIN());
		        artisanDao.ajouterTravail1(tra1,a.getCIN());
		        artisanDao.ajouterTravail2(tra2,a.getCIN());
		        artisanDao.ajouterTravail3(tra3,a.getCIN());
		        artisanDao.ajouterTravail4(tra4,a.getCIN());
		        artisanDao.ajouterLocal(local,a.getCIN()); 
		this.getServletContext().getRequestDispatcher("/WEB-INF/profilArtisan.jsp").forward(request, response);
	}
	
	
	
		private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
	        BufferedInputStream entree = null;
	        BufferedOutputStream sortie = null;
	        try {
	            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
	            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);
	
	            byte[] tampon = new byte[TAILLE_TAMPON];
	            int longueur;
	            while ((longueur = entree.read(tampon)) > 0) {
	                sortie.write(tampon, 0, longueur);
	            }
	        } finally {
	            try {
	                sortie.close();
	            } catch (IOException ignore) {
	            }
	            try {
	                entree.close();
	            } catch (IOException ignore) {
	            }
	        }
	    }
	    
	    private static String getNomFichier( Part part ) {
	        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
	            if ( contentDisposition.trim().startsWith( "filename" ) ) {
	                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
	            }
	        }
	        return null;
	    }   

}
