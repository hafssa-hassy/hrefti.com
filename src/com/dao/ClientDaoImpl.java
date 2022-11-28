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


import com.beans.Client;

public class ClientDaoImpl implements ClientDao {

    private static final String SQL_SELECT        = "SELECT * FROM Client ORDER BY CINc";
    private static final String SQL_SELECT_USERNAME_PASSWORD = "SELECT * FROM Client WHERE username=? and password=? ";
    private static final String SQL_SELECT_PAR_CIN = "SELECT * FROM Client WHERE CINc = ?";
    private static final String SQL_INSERT        = "INSERT INTO Client (CINc, nom, prenom,email,username,password,sexe,ville,telephone,dateNaissance) VALUES (?, ?, ?, ?, ?,? ,? ,? ,? ,? )";
    private static final String SQL_DELETE_PAR_CIN = "DELETE FROM Client WHERE CINc = ?";
    private static final String SQL_SELECT_PAR_EMAIL="SELECT * FROM Client WHERE email=?";
    private static final String SQL_SELECT_PAR_TELEPHONE="SELECT * FROM Client WHERE telephone=?";
    private static final String SQL_SELECT_PAR_USERNAME="SELECT * FROM Client WHERE username=?";

    private DAOFactory          daoFactory;

    ClientDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

   
    @Override
   
    public Client trouver( String CIN ) throws DAOException {
        return trouver( SQL_SELECT_PAR_CIN, CIN );
    }
    
    public Client trouverClient(String username, String password) {
    	return trouver(SQL_SELECT_USERNAME_PASSWORD, username,password);
    } 
    
    public Client trouverEmail(String email) {
    	return trouver(SQL_SELECT_PAR_EMAIL, email);
    } 
    public Client trouverUsername(String username) {
    	return trouver(SQL_SELECT_PAR_USERNAME, username);
    } 
    public Client trouverPhone(String telephone) {
    	return trouver(SQL_SELECT_PAR_TELEPHONE, telephone);
    } 

    
    @Override
    public void creer( Client client ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true,client.getCINc(),
                    client.getNom(), client.getPrenom(),  client.getEmail(),client.getUsername(),client.getPassword(),client.getSexe(),client.getVille(),
                    client.getTelephone(),   client.getDateNaissance());
                 
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "échec de la création du client, aucune ligne ajoutée dans la table." );
            }
           
           
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses(  preparedStatement, connexion );
        }
    }

  
    @Override
    public List<Client> lister() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Client> clients = new ArrayList<Client>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement( SQL_SELECT );
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                clients.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return clients;
    }

    
    @Override
    public void supprimer( Client client ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE_PAR_CIN, true, client.getCINc() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "échec de la suppression du client, aucune ligne supprimée de la table." );
            } else {
                client.setCINc( null );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }

   
    private Client trouver( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Client client = null;

        try {
           
            connexion = daoFactory.getConnection();
           
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
           
            if ( resultSet.next() ) {
                client = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return client;
    }

   
    private static Client map( ResultSet resultSet ) throws SQLException {
        Client client = new Client();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        client.setCINc( resultSet.getString( "CINc" ) );
        client.setNom( resultSet.getString( "nom" ) );
        client.setPrenom( resultSet.getString( "prenom" ) );
        client.setEmail( resultSet.getString( "email" ) );
        client.setUsername( resultSet.getString( "username" ) );
        client.setPassword( resultSet.getString( "password" ) );
        
        client.setSexe( resultSet.getString( "sexe" ) );
        client.setVille( resultSet.getString( "ville" ) );
        client.setTelephone( resultSet.getString( "telephone" ) );      
        client.setDateNaissance(LocalDate.parse(resultSet.getString("dateNaissance"),formatter));
        return client;
    }}

