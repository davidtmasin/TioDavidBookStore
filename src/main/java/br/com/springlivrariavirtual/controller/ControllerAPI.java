package br.com.springlivrariavirtual.controller;

import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.springlivrariavirtual.dao.LoginDAO;
import br.com.springlivrariavirtual.entities.Book;
import br.com.springlivrariavirtual.entities.Login;
import br.com.springlivrariavirtual.service.BookService;
import br.com.springlivrariavirtual.service.LoginService;

@Controller
public class ControllerAPI {
	
	@Autowired 
	private LoginDAO loginDAO;
	@Autowired
	private BookService bookservice;
	@Autowired
	private LoginService loginservice;
	
	/*@RequestMapping("/")*/
	@GetMapping("/")
	public String homePage(Login login) {
		
		return "index";
	}
	
	@PostMapping("/logonUser")
	public String logonUser(Login login, 
							HttpSession session, 
							RedirectAttributes redirectattributes) {
		
		/*if(login.getUserName().equals("admin")&&
		   login.getUserPassword().equals("1234")) {*/
		//login.setFullName("Administrador do Sistema");
		  login = this.loginDAO.findByUserNameAndUserPassword(login.getUserName(), 
				  											  login.getUserPassword());
		  if(login != null) {  
			 //Guardar sessão do objeto login
			session.setAttribute("userLogged", login);
			return "redirect:/literarycollection";
			
		} else {
			//Enviar uma mensagem no HTML
			redirectattributes.addFlashAttribute("message", "Login/senha inválidos!");
			return "redirect:/";
		}
	}
	
	@PostMapping("/logoutUser")
	public String logoutUser(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	@RequestMapping("/literarycollection")
	public String literaryCollection(Model model) {
		//O model é usando para pegar os dados e exibir
		//Pegando os dados do BD
		List<Book> books = bookservice.listAllBooks();
		//Ordenando em ordem crescente
		books.sort(Comparator.comparingLong(Book::getId));
		//jogando os dados através de um model
		model.addAttribute("books", books);
		
		return "literarycollection";
	}
	
	@RequestMapping("/newUser")
	public String newUser(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		return "registeruser";
	}
	
	@RequestMapping("/newBook")
	public String newBook(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "createbook";
	}
	
	@RequestMapping(value="/saveUser", method=RequestMethod.POST)
	public String saveUser(@ModelAttribute("login") Login login) {
		
		loginservice.createUserLogin(login);

		return "redirect:/";
	}
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("book") Book book) {
		
		bookservice.saveBook(book);

		return "redirect:/literarycollection";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView editBook(@PathVariable(name="id") long id) {
		
		ModelAndView modelandview = new ModelAndView("editbook");
		
		Book book = bookservice.updateBook(id);
		modelandview.addObject("book", book);
		
		return modelandview;
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name="id") long id) {
		
		bookservice.deleteBook(id);
		
		return "redirect:/literarycollection";		
	}
	
}
