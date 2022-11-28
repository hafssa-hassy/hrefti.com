package com.dao;

import java.util.List;


import com.beans.Client;

public interface ClientDao {
    void creer( Client client ) throws DAOException;

    Client trouver( String CIN ) throws DAOException;
    
    Client trouverClient (String username,String password) throws DAOException;
    
    Client trouverEmail (String email) throws DAOException;
    
    Client trouverUsername (String username) throws DAOException;
    
    Client trouverPhone(String telephone) throws DAOException;

    List<Client> lister() throws DAOException;

    void supprimer( Client client ) throws DAOException;
}