package com.beans;

import java.io.Serializable;
import java.time.LocalDate;

public class Artisan implements Serializable {

    private String CIN;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String sexe;
    private String profession;
    private String ville;
    private String telephone;
    private String adresse;
    private String email;
    private String username;
    private String password;
    private String descriptionFichier;
    private String fichier;
    private String image;
    private String dossEchantillons;
    private String local;
    private String psw2;
    private String experience;
    private String tra1;
	 private String tra2;
	 private String tra3;
	 private String tra4;
	 //private String localphoto;
    
	public String getTra1() {
		return tra1;
	}
	public void setTra1(String tra1) {
		this.tra1 = tra1;
	}
	public String getTra2() {
		return tra2;
	}
	public void setTra2(String tra2) {
		this.tra2 = tra2;
	}
	public String getTra3() {
		return tra3;
	}
	public void setTra3(String tra3) {
		this.tra3 = tra3;
	}
	public String getTra4() {
		return tra4;
	}
	public void setTra4(String tra4) {
		this.tra4 = tra4;
	}
	/*public String getLocalphoto() {
		return localphoto;
	}
	public void setLocalphoto(String localphoto) {
		this.localphoto = localphoto;
	}*/
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String CIN) {
		this.CIN = CIN;
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
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public String getFichier() {
		return fichier;
	}
	public void setFichier(String fichier) {
		this.fichier = fichier;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescriptionFichier() {
		return descriptionFichier;
	}
	public void setDescriptionFichier(String descriptionFichier) {
		this.descriptionFichier = descriptionFichier;
	}
	public String getDossEchantillons() {
		return dossEchantillons;
	}
	public void setDossEchantillons(String dossEchantillons) {
		this.dossEchantillons = dossEchantillons;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getPsw2() {
		return psw2;
	}
	public void setPsw2(String psw2) {
		this.psw2 = psw2;
	}


}
