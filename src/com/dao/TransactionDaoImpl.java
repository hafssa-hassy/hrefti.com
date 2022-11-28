package com.dao;



import static com.dao.DAOUtilitaire.fermeturesSilencieuses;
import static com.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.beans.Transaction;

public class TransactionDaoImpl implements TransactionDao {

    private static final String SQL_SELECT        = "SELECT DISTINCT * FROM Transaction where CIN_artisan=? and validation IS NULL";
    private static final String SQL_SELECT_PAR_ID = "SELECT * FROM Transaction WHERE id = ? ";
    private static final String SQL_UPDATE_TRANSACTION = "UPDATE Transaction SET validation='True' where CIN_artisan=? and CIN_client=?";
    private static final String SQL_INSERTION_TRANSACTION = "UPDATE Transaction SET justification=? where CIN_artisan=? and CIN_client=?";
    private static final String SQL_INSERT        = "INSERT INTO Transaction (CIN_artisan, CIN_client, date,message) VALUES (?, ?, ?,?)";
    private static final String SQL_DELETE_PAR_ID = "DELETE FROM Transaction WHERE id = ?";

    private DAOFactory          daoFactory;

    TransactionDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

   
    @Override
    public Transaction trouver( long id ) throws DAOException {
        return trouver( SQL_SELECT_PAR_ID, id );
    }
    
    @Override
    public void validation(String CIN_artisan,String CIN_client) throws DAOException{
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
       

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_UPDATE_TRANSACTION, false,
            		CIN_artisan,CIN_client   );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la modification de la transaction" );
            }
          
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }
    @Override
    public void insertion(String justification, String CIN_artisan,String CIN_client) throws DAOException{
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
       

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERTION_TRANSACTION, false,
            		justification ,CIN_artisan,CIN_client  );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "�chec de la modification de la transaction" );
            }
          
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );}
    }
    @Override
    public void creer( Transaction transaction ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
       

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true,transaction.getArtisan().getCIN(),
                    transaction.getClient().getCINc(), new Timestamp( transaction.getDate().getMillis()), transaction.getMessage() 
                    );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création de la commande, aucune ligne ajoutée dans la table." );
            }
          
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }

  
    @Override
    public List<Transaction> lister(String CIN_artisan) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Transaction> transactions = new ArrayList<Transaction>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connection,  SQL_SELECT, false, CIN_artisan);
            
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                transactions.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return transactions;
    }

    
    @Override
    public void supprimer( Transaction transaction ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE_PAR_ID, true, transaction.getId() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la suppression de la commande, aucune ligne supprimée de la table." );
            } else {
                transaction.setId( null );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }

   
    private Transaction trouver( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Transaction transaction = null;

        try {
           
            connexion = daoFactory.getConnection();
           
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
          
            if ( resultSet.next() ) {
                transaction = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return transaction;
    }

    
    private Transaction map( ResultSet resultSet ) throws SQLException {
        Transaction transaction = new Transaction();
        ArtisanDao artisanDao = daoFactory.getArtisanDao();
        transaction.setArtisan( artisanDao.trouver( resultSet.getString( "CIN_artisan" ) ) );
        
        ClientDao clientDao = daoFactory.getClientDao();
        transaction.setClient( clientDao.trouver( resultSet.getString( "CIN_client" ) ) );
        transaction.setMessage(resultSet.getString("message"));
       transaction.setValidation(resultSet.getString("validation"));
       transaction.setJustification(resultSet.getString("justification"));
   
        return transaction;
    }

}