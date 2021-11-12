package br.com.springlivrariavirtual.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springlivrariavirtual.entities.Login;

public interface LoginDAO extends JpaRepository<Login, Long> {
	
	public Login findByUserNameAndUserPassword(String userName, String userPassword);
	
}
