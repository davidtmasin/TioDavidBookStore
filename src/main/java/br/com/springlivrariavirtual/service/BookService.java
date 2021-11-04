package br.com.springlivrariavirtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springlivrariavirtual.entities.Book;
import br.com.springlivrariavirtual.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookrepository;
				//adicionar
	public void saveBook(Book book) {
		bookrepository.save(book);
	}
				//modificar
	public Book updateBook(Long id) {
		return bookrepository.findById(id).get();
	}
						//listar
	public List<Book> listAllBooks(){
		
		List<Book> books = bookrepository.findAll();
		
		for(Book b : books) {
			System.out.println(b.getBookName());
		}
		
		return books;
	}
				//deletar
	public void deleteBook(Long id) {
		bookrepository.deleteById(id);
	}
	
}
