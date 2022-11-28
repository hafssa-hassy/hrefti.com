package com.beans;

import java.io.Serializable;

import java.time.LocalDate;



public class Client implements Serializable  {
	
	private String CINc;
	
    private String nom;
    private String prenom;
    private String email;
    private String username;
    private String password;
    private String sexe;
    private String ville;
    private String telephone;
    private LocalDate dateNaissance;
    
	public String getCINc() {
		return CINc;
	}
	public void setCINc(String cINc) {
		CINc = cINc;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
//	public void setClientAttributes(String CINc,String nom,String prenom,String email,String username,String password,String sexe,String ville,String telephone,LocalDate dateNaissance) {
//		this.CINc = CINc;
//		this.nom = nom;
//		this.prenom =prenom;
//		this.email = email;
//		this.username = username;
//		this.password = password;
//
//		this.sexe = sexe;
//		this.ville = ville;
//		this.telephone = telephone;
//		this.dateNaissance = dateNaissance;
//	}

}


