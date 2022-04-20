package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="apikey1")
public class ApiKey {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	private String ipadress ;
	private String apikeyValue ;
	
	@OneToOne
	private Utilisateur utilisateur;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public ApiKey() {
		super();
		// TODO Auto-generated constructor stub
	}

		public String getIpadress() {
			return ipadress;
		}
		public void setIpadress(String ipadress) {
			this.ipadress = ipadress;
		}
		public String getApikeyValue() {
			return apikeyValue;
		}
		public void setApikeyValue(String apikeyValue) {
			this.apikeyValue = apikeyValue;
		}
		public ApiKey(Long id, String ipadress, String apikeyValue, Utilisateur utilisateur) {
			super();
			this.id = id;
			this.ipadress = ipadress;
			this.apikeyValue = apikeyValue;
			this.utilisateur = utilisateur;
		}
		public ApiKey(String ipadress, String apikeyValue) {
			super();
			this.ipadress = ipadress;
			this.apikeyValue = apikeyValue;
		}
		@Override
		public String toString() {
			return "ApiKey [id=" + id + ", ipadress=" + ipadress + ", apikeyValue=" + apikeyValue + ", utilisateur="
					+ utilisateur + "]";
		}
		
}
