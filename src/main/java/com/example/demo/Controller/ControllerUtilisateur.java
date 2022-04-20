package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.Apikey1Service;
import com.example.demo.Service.UtilisateurService;
import com.example.demo.dto.ApiKeyDto;
import com.example.demo.entities.Utilisateur;

@RestController
public class ControllerUtilisateur {
	@Autowired
	UtilisateurService utilisateurservice;
	@Autowired
	Apikey1Service apk;
	public List<Utilisateur> getAllutilisateurs() {
		List<Utilisateur> list = utilisateurservice.getAllUtilisateur();
		return list;
	}

	@PostMapping("/Ajouterutilisateur")
	@ResponseBody
	public Utilisateur AjouterUtilisateur(@RequestBody Utilisateur u) {
		return utilisateurservice.AjouterUtilisateur(u);
	}
	
	@PostMapping("/apikey/{iduser}")
	@ResponseBody
	public void effectuerUtilisateur(@RequestBody ApiKeyDto apikeydto, @PathVariable long iduser) {
		
		apk.addapi(apikeydto,iduser );
	}
	@PostMapping("/validateApikey")
	@ResponseBody
	public String validateApikey(@RequestBody ApiKeyDto apikeydto) {
		System.out.println(apikeydto.toString());
		return apk.validateApi(apikeydto );
	}

}
