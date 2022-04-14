package com.example.demo.ServiceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.Apikey1Repository;
import com.example.demo.Repository.UtilisateurRepository;
import com.example.demo.Service.UtilisateurService;
import com.example.demo.dto.ApiKeyDto;
import com.example.demo.entities.ApiKey;
import com.example.demo.entities.Utilisateur;

@Service
public class UtilisateurServiceImpl implements UtilisateurService, UserDetailsService {
	@Autowired
	UtilisateurRepository Utilisateurrepos;
	Apikey1Repository Apikey1repos;
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur utilisteur = Utilisateurrepos.findByUsername(username);
		if (utilisteur == null) {
			// Log.error("utilisateur not found in database");
			throw new UsernameNotFoundException("utilisateur not found in database");
		} else {
			// Log.infof("utilisateur found in database:{}", username);
		}

		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

		return new org.springframework.security.core.userdetails.User(utilisteur.getUsername(),
				utilisteur.getPassword(), authorities);
	}

	@Override
	public Utilisateur AjouterUtilisateur(Utilisateur u) {
		Utilisateurrepos.save(u);

		return u;
	}

	@Override
	public void DeleteUtilisateur(Utilisateur u) {
		Utilisateurrepos.delete(u);

	}

	@Override
	public Utilisateur EffectuerUtilisateur(Utilisateur u) {
		Utilisateurrepos.save(u);
		return (u);
	}

	@Override
	public List<Utilisateur> getAllUtilisateur() {
		return (List<Utilisateur>) Utilisateurrepos.findAll();

	}

	@Override
	public Optional<Utilisateur> finduserbyId(long id) {
		return Utilisateurrepos.findById(id);
	}

	@Override
	public Utilisateur saveUtilisateur(Utilisateur u) {
		// Log.infof("saving utilisateur", u.getNom());
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return Utilisateurrepos.save(u);
	}

}
