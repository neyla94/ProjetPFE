package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Utilisateur;


public interface UtilisateurService {
	Utilisateur AjouterUtilisateur(Utilisateur u);
	void  DeleteUtilisateur(Utilisateur u);
	Utilisateur EffectuerUtilisateur(Utilisateur u);
	List<Utilisateur> getAllUtilisateur();
	Optional<Utilisateur> finduserbyId(long id);
	
Utilisateur	saveUtilisateur(Utilisateur u);


}
