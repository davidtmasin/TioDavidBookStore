package br.com.springlivrariavirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springlivrariavirtual.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
