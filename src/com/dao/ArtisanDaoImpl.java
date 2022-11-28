package com.dao;

import static com.dao.DAOUtilitaire.fermeturesSilencieuses;

import static com.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.beans.Artisan;

public class ArtisanDaoImpl implements ArtisanDao {

    private static final String SQL_SELECT        = "SELECT * FROM Artisan ORDER BY CIN";
    private static final String SQL_SELECT_USERNAME_PASSWORD = "SELECT * FROM Artisan WHERE username=? and password=? ";
    private static final String SQL_SELECT_PAR_CIN = "SELECT * FROM Artisan WHERE CIN=? ";
    private static final String SQL_SELECT_PAR_PROFESSION = "SELECT * FROM Artisan WHERE profession=? ORDER BY nom";
    private static final String SQL_SELECT_PAR_NOM = "SELECT * FROM Artisan WHERE nom= ? ORDER BY nom";
    private static final String SQL_SELECT_PAR_NOM_PROFESSION="SELECT nom, prenom, image  FROM Artisan WHERE nom= ? OR profession=?";
    private static final String SQL_SELECT_PAR_EMAIL="SELECT * FROM Artisan WHERE email=?";
    private static final String SQL_SELECT_PAR_TELEPHONE="SELECT * FROM Artisan WHERE telephone=?";
    private static final String SQL_SELECT_PAR_USERNAME="SELECT * FROM Artisan WHERE username=?";
    private static final String SQL_INSERT        = "INSERT INTO Artisan (CIN, nom ,prenom,dateNaissance, sexe, profession, ville, telephone, adresse, email, username, password, fichier,descriptionFichier, image ,DossEchantillons ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,? ,? ,? ,?,?,?)";
    private static final String SQL_DELETE_PAR_CIN = "DELETE FROM Artisan WHERE CIN = ?";
    private static final String SQL_INSERT_EXPERIENCE = "UPDATE  Artisan SET experience= ? WHERE CIN =?";
    private static final String SQL_INSERT_TRAVAIL1 = "UPDATE  artisan SET tra1= ? WHERE CIN =?";
    private static final String SQL_INSERT_TRAVAIL2 = "UPDATE  artisan SET tra2= ? WHERE CIN =?";
    private static final String SQL_INSERT_TRAVAIL3 = "UPDATE  artisan SET tra3= ? WHERE CIN =?";
    private static final String SQL_INSERT_TRAVAIL4 = "UPDATE  artisan SET tra4= ? WHERE CIN =?";
    private static final String SQL_INSERT_LOCAL = "UPDATE  Artisan SET local= ? WHERE CIN =?";
    private static final String SQL_COUNT = "select * , count(nom) from artisan where nom=?";

    private DAOFactory          daoFactory;

    ArtisanDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

   
    @Override
    public Artisan trouverProf( String profession ) throws DAOException {
        return trouver( SQL_SELECT_PAR_PROFESSION, profession );
    }
    public Artisan trouver( String CIN ) throws DAOException {
        return trouver( SQL_SELECT_PAR_CIN, CIN );
    }
    
    public Artisan trouverNom( String nom ) throws DAOException {
        return trouver( SQL_SELECT_PAR_NOM, nom );
    }
    
    public Artisan trouverNomProf( String nom, String profession ) throws DAOException {
        return trouver( SQL_SELECT_PAR_NOM_PROFESSION, nom, profession );
    }
    
    public Artisan trouverArtisan(String username, String password) {
    	return trouver(SQL_SELECT_USERNAME_PASSWORD, username,password);
    } 
    public Artisan trouverEmail(String email) {
    	return trouver(SQL_SELECT_PAR_EMAIL, email);
    } 
    public Artisan trouverUsername(String username) {
    	return trouver(SQL_SELECT_PAR_USERNAME, username);
    } 
    public Artisan trouverPhone(String telephone) {
    	return trouver(SQL_SELECT_PAR_TELEPHONE, telephone);
    } 
   
    
    
   
    @Override
    public void creer( Artisan artisan ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
       

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, artisan.getCIN(), artisan.getNom(), artisan.getPrenom(),artisan.getDateNaissance(),artisan.getSexe(), artisan.getProfession(),artisan.getVille(), artisan.getTelephone(),	artisan.getAdresse(),
            		artisan.getEmail(),artisan.getUsername(),artisan.getPassword(),artisan.getFichier(),artisan.getDescriptionFichier(),artisan.getImage(),artisan.getDossEchantillons());
            	
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "échec de la création de l'artisan, aucune ligne ajoutée dans la table." );
            }
           
           
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses(  preparedStatement, connexion );
        }
    }

    
    @Override
    public List<Artisan> lister(String profession) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Artisan> artisans = new ArrayList<Artisan>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connection,  SQL_SELECT_PAR_PROFESSION, false, profession);
 
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                artisans.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return artisans;
    }
    @Override
    public void ajouter( String experience,String CIN ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT_EXPERIENCE, false, experience,CIN );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "échec de la modification de la table artisan." );
            } 
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }
    @Override
    public void ajouterTravail1( String travail,String CIN ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT_TRAVAIL1, false, travail,CIN );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "échec de la modification de la table artisan." );
            } 
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }
    @Override
    public void ajouterTravail2( String travail,String CIN ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT_TRAVAIL2, false, travail,CIN );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "échec de la modification de la table artisan." );
            } 
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }
    @Override
    public void ajouterTravail3( String travail,String CIN ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT_TRAVAIL3, false, travail,CIN );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "échec de la modification de la table artisan." );
            } 
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }
    @Override
    public void ajouterTravail4( String travail,String CIN ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT_TRAVAIL4, false, travail,CIN );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "échec de la modification de la table artisan." );
            } 
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }


   
    @Override
    public void supprimer( Artisan artisan ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE_PAR_CIN, true, artisan.getCIN() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "échec de la suppression de l'artisan, aucune ligne supprimée de la table." );
            } else {
                artisan.setCIN( null );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }
    @Override
    public void ajouterLocal( String local,String CIN ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT_LOCAL, false, local,CIN );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "échec de la modification de la table artisan." );
            } 
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }

    private Artisan trouver( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Artisan artisan = null;

        try {
            
            connexion = daoFactory.getConnection();
           
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
           
            if ( resultSet.next() ) {
                artisan = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return artisan;
    }
    
    public String count(String Rech) throws DAOException {
    	
      	 Connection connexion = null;
           PreparedStatement preparedStatement = null;
           ResultSet rs = null;
           String Countrow="";
           try {
               connexion = daoFactory.getConnection();
               preparedStatement = initialisationRequetePreparee( connexion, SQL_COUNT, false,Rech);
               rs = preparedStatement.executeQuery();
            	
          	while(rs.next()){
          	Countrow = rs.getString(1);
          }
              
              
              
           }catch ( SQLException e ) {
               throw new DAOException( e );
           } finally {
               fermeturesSilencieuses(  preparedStatement, connexion );
           }
   return Countrow;
   }
    

    private static Artisan map( ResultSet resultSet ) throws SQLException {
        Artisan artisan = new Artisan();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        artisan.setCIN( resultSet.getString( "CIN" ) );
    artisan.setNom( resultSet.getString( "nom" ) );
    artisan.setPrenom( resultSet.getString( "prenom" ) );
    artisan.setDateNaissance(LocalDate.parse(resultSet.getString("dateNaissance"),formatter));
     artisan.setSexe( resultSet.getString( "sexe" ) );
      artisan.setProfession( resultSet.getString( "profession" ) );
      artisan.setVille( resultSet.getString( "ville" ) );
      artisan.setTelephone( resultSet.getString( "telephone" ) );
      artisan.setAdresse( resultSet.getString( "adresse" ) );
      artisan.setEmail( resultSet.getString( "email" ) );
     artisan.setUsername( resultSet.getString( "username" ) );
     artisan.setPassword( resultSet.getString( "password" ) );
     
     
     artisan.setFichier( resultSet.getString( "fichier" ) );
     artisan.setDescriptionFichier( resultSet.getString( "descriptionFichier" ) );
      artisan.setImage( resultSet.getString( "image" ) );
     artisan.setDossEchantillons( resultSet.getString( "DossEchantillons" ) );
     artisan.setExperience( resultSet.getString( "experience" ) );
     artisan.setTra1( resultSet.getString( "tra1" ) );
     artisan.setTra2( resultSet.getString( "tra2" ) );
     artisan.setTra3( resultSet.getString( "tra3" ) );
     artisan.setTra4( resultSet.getString( "tra4" ) );
     artisan.setLocal( resultSet.getString( "local" ) );
     return artisan;
    }

    
}
