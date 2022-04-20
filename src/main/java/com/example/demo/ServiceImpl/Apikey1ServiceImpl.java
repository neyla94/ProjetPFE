package com.example.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.Apikey1Repository;
import com.example.demo.Repository.UtilisateurRepository;
import com.example.demo.Service.Apikey1Service;
import com.example.demo.Service.UtilisateurService;
import com.example.demo.dto.ApiKeyDto;
import com.example.demo.entities.ApiKey;
import com.example.demo.entities.Utilisateur;

@Service
public class Apikey1ServiceImpl implements Apikey1Service {
	@Autowired
	Apikey1Repository aprepo;

	@Autowired
	UtilisateurRepository userrepo;

	@Override
	public void addapi(ApiKeyDto ap, Long idUser) {
		ApiKey apiToSave = new ApiKey();
		apiToSave.setIpadress(ap.getIpadress());
		aprepo.save(apiToSave);

	}

	@Override
	public String validateApi(ApiKeyDto ap) {
		ApiKey apiToValidate = aprepo.getApiKey(ap.getApikeyValue());

		if (apiToValidate != null) {
			String s = "";
			if (apiToValidate.getApikeyValue().equals(ap.getApikeyValue())) {
				if (!apiToValidate.getIpadress().equals(ap.getIpadress())) {
					s = "IP not valid";
					return s;
				} else {
					s = "is valid";
					Utilisateur user = userrepo.getById(apiToValidate.getUtilisateur().getId());

					if (user != null) {
						String login = user.getUsername();
						String psw = user.getPassword();

						// auth method

						return s = (login+psw);
					} else {
						s = "user not found";
					}
				}
			}

			else {
				return s = "you can't access";
			}
			return s;

		} else {
			return "apikey is not found in the database";

		}

	}
}
