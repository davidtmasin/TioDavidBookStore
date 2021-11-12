package br.com.springlivrariavirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springlivrariavirtual.entities.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

	
}
