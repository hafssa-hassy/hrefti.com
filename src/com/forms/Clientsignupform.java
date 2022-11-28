package com.forms;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;




import com.dao.ClientDao;
import com.dao.DAOFactory;
import com.beans.Client;

public class Clientsignupform {
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
	private String              resultat;
	private Map<String, String> erreurs      = new HashMap<String, String>();
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private ClientDao clientDao;

	public String getResultat() {
	    return resultat;
	}

	public Map<String, String> getErreurs() {
	    return erreurs;
	}
	  public Client verifierClient( HttpServletRequest request ) {
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
	        Client client = new Client();
	        DAOFactory daoFactory = DAOFactory.getInstance();
			this.clientDao=daoFactory.getClientDao();
	        client.setSexe( sexe );
	        client.setVille( ville );
	        client.setDateNaissance( LocalDate.parse(datenai,formatter) );
	        try {
	            validationFirstname( firstname );
	        } catch ( Exception e ) {
	            setErreur( CHAMP_FIRSTNAME, e.getMessage() );
	        }
	        client.setPrenom( firstname );
	        try {
	            validationLastname( lastname );
	        } catch ( Exception e ) {
	            setErreur( CHAMP_LASTNAME, e.getMessage() );
	        }
	        client.setNom( lastname );
	        
	        try {
	            validationUname( uname );
	        } catch ( Exception e ) {
	            setErreur( CHAMP_UNAME, e.getMessage() );
	        }
	        client.setUsername( uname );
	        try {
	            validationCIN( CIN );
	        } catch ( Exception e ) {
	            setErreur( CHAMP_CIN, e.getMessage() );
	        }
	        client.setCINc( CIN );

	        try {
	            validationPhone( phone );
	        } catch ( Exception e ) {
	            setErreur( CHAMP_PHONE, e.getMessage() );
	        }
	        client.setTelephone( phone );
	        try {
	            validationEmail( email );
	        } catch ( Exception e ) {
	            setErreur( CHAMP_EMAIL, e.getMessage() );
	        }
	        client.setEmail( email );
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
	        client.setPassword( psw );
	        if ( erreurs.isEmpty() ) {
	            resultat = "Succés de l'inscription Client  ";
	        } else {
	            resultat = "échec de l'inscription client";
	        }

	        return client;
	    }
	  private void validationFirstname( String firstname ) throws Exception {
	        if ( firstname != null ) {
	            if ( firstname.length() < 4 ) {
	                throw new Exception( "Le prénom doit contenir au moins 4 caractères." );
	        } 
	        }
	    }
	  private void validationLastname( String lastname ) throws Exception {
	        if ( lastname != null ) {
	            if ( lastname.length() < 4 ) {
	                throw new Exception( "Le nom doit contenir au moins 4 caractères." );
	        }
	        }
	    }
	    private void validationUname( String uname ) throws Exception {
	        if (  uname != null ) {
	        	 Client c = clientDao.trouverUsername(uname);
	        	 if(c!=null) {
	    			 throw new Exception( "Ce nom d'utilisateur est déjà utilisé" );
	    		 }
	            if ( uname.length() < 4 ) {
	                throw new Exception( "Le nom d'uitilsateur doit contenir au moins 4 caractères." );
	            }
	        }
	    }

	    private void validationCIN( String CIN ) throws Exception {
	        if ( CIN != null ) {
	        	 Client c = clientDao.trouver(CIN);
	        	 if(c!=null) {
	    			 throw new Exception( "CIN déjà utilisé" );
	    		 }
	            if ( CIN.length() != 7 ) {
	                throw new Exception( "Le code de votre CIN doit contenir 7 caractères." );
	           
	            }
	        }
	    }

	    private void validationPhone( String phone ) throws Exception {
	        if ( phone != null ) {
	        	 Client c = clientDao.trouverPhone(phone);
	        	 if(c!=null) {
	    			 throw new Exception( "Ce numéro de téléphone est déjà utilisé" );
	    		 }
	            
	            if ( phone.length() != 10 ) {
	                throw new Exception( "Le numéro de téléphone doit contenir 10 chiffres." );
	            }
	    }
	    }

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
	                throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
	        } 
	    }
	    }
	    
	    private void validationEmail(String email) throws Exception{
	    	if(email!=null) { 
	    		Client c = clientDao.trouverEmail(email);
	    		if(c!=null) {
				 throw new Exception( "Cet email est déjà utilisé" );
			 }
	   
	    	if(!(email.endsWith("@gmail.com")||(email.endsWith("@hotmail.fr"))||(email.endsWith("@hotmail.com")))){
	    		throw new Exception("Votre email est invalide");
	    	}
	    }}
	    /*
	     * Ajoute un message correspondant au champ sp�cifi� � la map des erreurs.
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
