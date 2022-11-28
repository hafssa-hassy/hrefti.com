package com.dao;

import java.util.List;

import com.beans.Artisan;

public interface ArtisanDao {
    void creer( Artisan artisan ) throws DAOException;
    
    Artisan trouver( String CIN ) throws DAOException;

    Artisan trouverProf( String profession ) throws DAOException;
   
    Artisan trouverNom(String nom) throws DAOException;
    
    Artisan trouverNomProf(String nom, String profession) throws DAOException;
    
    Artisan trouverEmail (String email) throws DAOException;
    
    Artisan trouverUsername (String username) throws DAOException;
    
    Artisan trouverPhone(String telephone) throws DAOException;
    
    void ajouter(String experience,String CIN ) throws DAOException;
    
    String count(String Rech) throws DAOException;
    
    void ajouterTravail1(String travail,String CIN ) throws DAOException;
    void ajouterTravail2(String travail,String CIN ) throws DAOException;
    void ajouterTravail3(String travail,String CIN ) throws DAOException;
    void ajouterTravail4(String travail,String CIN ) throws DAOException;
    void ajouterLocal(String local,String CIN ) throws DAOException;
    
    Artisan trouverArtisan (String username,String password) throws DAOException;

    List<Artisan> lister(String profession) throws DAOException;

    void supprimer( Artisan artisan ) throws DAOException;
}
