package com.example.demo.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity

public class UtilisateurDto {
@Id  @GeneratedValue(strategy =GenerationType.AUTO)

	private Long id;
	private String nom;
	private String prenom;
	private String adresse;
	private String username;
	private String password;

	public UtilisateurDto(String nom, String prenom, String adresse, String username, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.username = username;
		this.password = password;
	}

	public UtilisateurDto(Long id, String nom, String prenom, String adresse, String username, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.username = username;
		this.password = password;
	}

	public UtilisateurDto(String nom, String prenom, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public UtilisateurDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void setUtilisateur(String username2) {
		// TODO Auto-generated method stub

	}

	public void setApiKey(String apiKy) {
		// TODO Auto-generated method stub

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

}
