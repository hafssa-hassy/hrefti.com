package com.forms;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.beans.Artisan;

import com.dao.ArtisanDao;
import com.dao.DAOFactory;


public class Artisansignupform {
	  private static final String CHAMP_FIRSTNAME  = "firstname";
	  private static final String CHAMP_LASTNAME = "lastname";
	    private static final String CHAMP_CIN   = "CIN";
	    private static final String CHAMP_SEXE   = "sexe";
	    private static final String CHAMP_VILLE   = "ville";	
	    private static final String CHAMP_PHONE   = "phone";
	    private static final String CHAMP_EMAIL   = "email";
	    private static final String CHAMP_UNAME   = "uname";
	    private static final String CHAMP_PSW   = "psw";
	    private static final String CHAMP_PSW2   = "psw2";
	    private static final String CHAMP_DATENAI   = "datenai";
	    private static final String CHAMP_PROFESSION   = "profession";
	    private static final String CHAMP_LOCAL   = "local";
	    private static final String CHAMP_ADRESS   = "adress";
	    private static final String CHAMP_FICHIER   = "fichier";
	    private static final String CHAMP_DESCRIPTION   = "description";
	    private static final String CHAMP_IMAGE   = "image";
	private String              resultat;
	private Map<String, String> erreurs      = new HashMap<String, String>();
	
	private ArtisanDao artisanDao;

	public String getResultat() {
	    return resultat;
	}
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public Map<String, String> getErreurs() {
	    return erreurs;
	}
	  public Artisan creerArtisan( HttpServletRequest request ) {
	        String firstname = getValeurChamp( request,CHAMP_FIRSTNAME  );
	        String lastname = getValeurChamp( request,CHAMP_LASTNAME);
	        String CIN = getValeurChamp( request,CHAMP_CIN);
	        String sexe = getValeurChamp( request,  CHAMP_SEXE);
	        String ville = getValeurChamp( request, CHAMP_VILLE);
	        String phone = getValeurChamp( request, CHAMP_PHONE);
	        String email = getValeurChamp( request, CHAMP_EMAIL);
	        String uname = getValeurChamp( request, CHAMP_UNAME);
	        String psw = getValeurChamp( request, CHAMP_PSW);
	        String psw2 = getValeurChamp( request, CHAMP_PSW2);
	        String datenai = getValeurChamp( request, CHAMP_DATENAI);
	        String profession = getValeurChamp( request, CHAMP_PROFESSION);
	        String local = getValeurChamp( request, CHAMP_LOCAL);
	        String adress = getValeurChamp( request, CHAMP_ADRESS);
	        //String fichier =getValeurChamp(request,CHAMP_FICHIER );
	        String description =getValeurChamp(request,CHAMP_DESCRIPTION );
	        //String image =getValeurChamp(request,CHAMP_IMAGE );
	        Artisan artisan = new Artisan();
	        DAOFactory daoFactory = DAOFactory.getInstance();
			this.artisanDao=daoFactory.getArtisanDao();
	        artisan.setSexe( sexe );
	        artisan.setVille( ville );
	        artisan.setDateNaissance( LocalDate.parse(datenai,formatter) );
	        artisan.setProfession( profession );
	        //artisan.setFichier(fichier);
	        artisan.setDescriptionFichier(description);
	       // artisan.setImage(image);
	        artisan.setPsw2(psw2);
	        try {
	            validationFirstname( firstname );
	        } catch ( Exception e ) {
	            setErreur( CHAMP_FIRSTNAME, e.getMessage() );
	        }
	        artisan.setPrenom( firstname );
	        try {
	            validationLastname( lastname );
	        } catch ( Exception e ) {
	            setErreur( CHAMP_LASTNAME, e.getMessage() );
	        }
	        artisan.setNom( lastname );
	        
	        try {
	            validationUname( uname );
	        } catch ( Exception e ) {
	            setErreur( CHAMP_UNAME, e.getMessage() );
	        }
	        artisan.setUsername( uname );
	        try {
	            validationCIN( CIN );
	        } catch ( Exception e ) {
	            setErreur( CHAMP_CIN, e.getMessage() );
	        }
	        artisan.setCIN( CIN );

	        try {
	            validationPhone( phone );
	        } catch ( Exception e ) {
	            setErreur( CHAMP_PHONE, e.getMessage() );
	        }
	        artisan.setTelephone( phone );
	        try {
	            validationEmail( email );
	        } catch ( Exception e ) {
	            setErreur( CHAMP_EMAIL, e.getMessage() );
	        }
	        artisan.setEmail( email );
	        try {
	            validationAdress( local, adress );
	        } catch ( Exception e ) {
	            setErreur( CHAMP_ADRESS, e.getMessage() );
	        }
	        artisan.setAdresse( adress );
	        try {
	            validationPsw( psw );
	        } catch ( Exception e ) {
	            setErreur( CHAMP_PSW, e.getMessage() );
	        }
	        try {
	            validationPsw2( psw, psw2 );
	        } catch ( Exception e ) {
	            setErreur( CHAMP_PSW2, e.getMessage() );
	        }
	        artisan.setPassword( psw );
	        if ( erreurs.isEmpty() ) {
	            resultat = "Succ??s de la cr??ation de l'artisan ";
	        } else {
	            resultat = "??chec de la cr??ation de l'artisan.";
	        }

	        return artisan;
	    }
	  private void validationFirstname( String firstname ) throws Exception {
	        if ( firstname != null ) {
	            if ( firstname.length() < 4 ) {
	                throw new Exception( "Le pr??nom doit contenir au moins 4 caract??res." );
	        } 
	        }
	    }
	  private void validationLastname( String lastname ) throws Exception {
	        if ( lastname != null ) {
	            if ( lastname.length() < 4 ) {
	                throw new Exception( "Le nom doit contenir au moins 4 caract??res." );
	        }
	        }
	    }
	    private void validationUname( String uname ) throws Exception {
	        if (  uname != null ) {
	        	 Artisan a = artisanDao.trouverUsername(uname);
	        	 if(a!=null) {
	    			 throw new Exception( "Ce nom d'utilisateur est d??j?? utilis??" );
	    		 }
	            if ( uname.length() < 4 ) {
	                throw new Exception( "Le nom d'utilisateur doit contenir au moins 4 caract??res." );
	            }
	        }
	    }

	    private void validationCIN( String CIN ) throws Exception {
	        if ( CIN != null ) {
	        	Artisan a = artisanDao.trouver(CIN);
	        	 if(a!=null) {
	    			 throw new Exception( "CIN d??j?? utilis??e" );
	    		 }
	            if ( CIN.length() != 7 ) {
	                throw new Exception( "Le code de votre CIN doit contenir 7 caract??res." );
	           
	            }
	        }
	    }

	    private void validationPhone( String phone ) throws Exception {
	        if ( phone != null ) {
	        	Artisan a = artisanDao.trouverPhone(phone);
	   		 if(a!=null) {
	   			 throw new Exception( "Ce num??ro de t??l??phone est d??j?? utilis??" );
	   		 }
	            if ( phone.length() != 10 ) {
	                throw new Exception( "Le num??ro de t??l??phone doit contenir 10 chiffres." );
	            }
	    }
	    }
	    private void validationAdress( String local,String adress ) throws Exception {
	        if ( local.equals("oui") && adress==null) {
	                throw new Exception( "Vous devez remplir le champs d'adresse du local" );
	            }
	    }	    
	    private void validationEmail(String email) throws Exception{
	    	if(email!=null) { 
	    		Artisan a = artisanDao.trouverEmail(email);
	    		if(a!=null) {
				 throw new Exception( "Cet email est d??j?? utilis??" );
			 }
	   
	    	if(!(email.endsWith("@gmail.com")||(email.endsWith("@hotmail.fr"))||(email.endsWith("@hotmail.com")))){
	    		throw new Exception("Votre email est invalide");
	    	}
	    }}
	    private void validationPsw( String psw ) throws Exception {
	        if ( psw != null ) {
	        	char ch;
			    boolean capitalFlag = false;
			    boolean lowerCaseFlag = false;
			    boolean numberFlag = false;
			    for(int i=0; i < psw.length();i++) {
			        ch = psw.charAt(i);
			        if( Character.isDigit(ch)) {
			            numberFlag = true;
			        }
			        else if (Character.isUpperCase(ch)) {
			            capitalFlag = true;
			        } else if (Character.isLowerCase(ch)) {
			            lowerCaseFlag = true;
			        }
			        }
			    if(!numberFlag || !capitalFlag || !lowerCaseFlag) {
	                throw new Exception( "Le mot de passe doit au moins contenir une lettre en miniscule,une lettre en majuscule et un chiffre");
	        }     
	        }
	        }
	        
	    private void validationPsw2( String psw, String psw2 ) throws Exception {
	        if ( psw != null && psw2 != null ) {
	            if ( !psw.equals(psw2) )  {
	                throw new Exception( "Les mots de passe entr??s sont diff??rents, merci de les saisir ?? nouveau." );
	        } 
	    }
	    }
	    /*
	     * Ajoute un message correspondant au champ sp??cifi?? ?? la map des erreurs.
	     */
	    private void setErreur( String champ, String message ) {
	        erreurs.put( champ, message );
	    }
	   private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
	        String valeur = request.getParameter( nomChamp );
	        if ( valeur == null || valeur.trim().length() == 0 ) {
	            return null;
	        } else {
	            return valeur;
	        }
	    }

}
