package com.dao;


import java.util.List;

import com.beans.Transaction;

public interface TransactionDao {
    void creer( Transaction transaction ) throws DAOException;

    Transaction trouver( long id ) throws DAOException;
    
    void validation(String CIN_artisan, String CIN_client) throws DAOException;
    
    void insertion(String justification,String CIN_artisan, String CIN_client ) throws DAOException;

    List<Transaction> lister(String CIN_artisan) throws DAOException;

    void supprimer( Transaction transaction ) throws DAOException;
}