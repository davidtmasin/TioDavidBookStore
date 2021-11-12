package br.com.springlivrariavirtual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springlivrariavirtual.entities.Login;
import br.com.springlivrariavirtual.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	LoginRepository loginrepository;
	
	public void createUserLogin(Login login) {
		loginrepository.save(login);
	}
}
