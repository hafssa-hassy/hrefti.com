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
import com.forms.Artisansignupform;


@WebServlet("/ArtisanForm")
@MultipartConfig( location= "C:/fichiertemp" ,
		fileSizeThreshold = 1048576, 
		maxFileSize = 52428800,
		maxRequestSize = 52428800)

public class ArtisanForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static final int TAILLE_TAMPON = 10240;
	  
	 
    public ArtisanForm() {
        super();
        
    }
    
    private ArtisanDao artisanDao;
    public void init() throws ServletException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		this.artisanDao=daoFactory.getArtisanDao();
		
	}
    
 
	
    public static final String ATT_ARTISAN = "artisan";
    public static final String ATT_FORM   = "artisanform";

    public static final String VUE_SUCCES = "/WEB-INF/login.jsp";
    public static final String VUE_FORM   = "/WEB-INF/signupArtisan.jsp";
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/signupArtisan.jsp").forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	   InputStream in =ArtisanForm.class.getClassLoader().getResourceAsStream("config.properties");
		Properties prop= new Properties () ;
		prop.load(in);
		String CHEMIN_FICHIERS=prop.getProperty( "urlFichiersArtisans" );
		String CHEMIN_IMAGES = prop.getProperty( "urlImagesArtisans" );
		String PATH =prop.getProperty( "urlEchantillons" );
		
		
		String userType="a";
        HttpSession session = request.getSession();

        session.setAttribute("userType", userType);
		 // On récupère le champ description comme d'habitude
        String description = request.getParameter("description");
        request.setAttribute("description", description );

        // On récupère le champ du fichier
        Part part = request.getPart("fichier");
        Part part2 = request.getPart("image");
            
        // On vérifie qu'on a bien reçu un fichier
        String nomFichier = getNomFichier(part);
        String nomImage = getNomFichier(part2);
        request.setAttribute("nomImage", nomImage);
        request.setAttribute("nomFichier", nomFichier);
        
        // Si on a bien un fichier
        if (nomFichier != null && !nomFichier.isEmpty()) {
            String nomChamp = part.getName();
            // Corrige un bug du fonctionnement d'Internet Explorer
             nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
                    .substring(nomFichier.lastIndexOf('\\') + 1);

            // On écrit définitivement le fichier sur le disque
            ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);

            request.setAttribute(nomChamp, nomFichier);
        }
        if (nomImage != null && !nomImage.isEmpty()) {
            String nomChamp2 = part2.getName();
            // Corrige un bug du fonctionnement d'Internet Explorer
             nomImage = nomImage.substring(nomImage.lastIndexOf('/') + 1)
                    .substring(nomImage.lastIndexOf('\\') + 1);

            // On écrit définitivement le fichier sur le disque
            ecrireFichier(part2, nomImage, CHEMIN_IMAGES);

            request.setAttribute(nomChamp2, nomImage);
        }

        Artisansignupform form = new Artisansignupform();

        // Traitement de la requête et récupération du bean en résultant 
        Artisan artisan = form.creerArtisan( request ); 
  
        // Ajout du bean et de l'objet métier à l'objet requête 
        request.setAttribute( ATT_ARTISAN, artisan );
        request.setAttribute( ATT_FORM, form );

        if ( form.getErreurs().isEmpty() ) {
            // Si aucune erreur, alors affichage de la fiche récapitulative 
        	artisan.setFichier(nomFichier);  
        	artisan.setImage(nomImage);
        	
        	artisan.setDossEchantillons(artisan.getUsername());
            //Creating a File object
            File file = new File(PATH+artisan.getUsername());
            //Creating the directory
            boolean bool = file.mkdir();
            //test sur la création du fichier
            
            
      //insertion du client dans la base de données
    	artisanDao.creer(artisan);
        this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            // Sinon, ré-affichage du formulaire de création avec les erreurs 
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
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
