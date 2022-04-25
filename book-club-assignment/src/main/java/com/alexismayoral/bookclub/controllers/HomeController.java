package com.alexismayoral.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.alexismayoral.bookclub.models.Book;
import com.alexismayoral.bookclub.services.MainService;
import com.alexismayoral.bookclub.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private MainService mainService;
	
	@Autowired
	private UserService userService;
	
	//home page
	@GetMapping("/home")
	public String home(Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		
		String username = userService.getUserById((Long)session.getAttribute("userId")).getUserName();
		
		model.addAttribute("username", username);
		model.addAttribute("books", mainService.allBooks());
		return "home.jsp";
	}
	
	//create 
	@GetMapping("/books/new")
	public String newBookForm(@ModelAttribute("book")Book book) {
		return "newBook.jsp";
	}
	//create
	@PostMapping("/books/new")
	public String processCreateGift(@Valid @ModelAttribute("book")Book book,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "newBook.jsp";
		}else {
			mainService.createBook(book);
			return "redirect:/home";
		}
	}
	
	//edit
	@GetMapping("/books/{id}/edit")
	public String editBookForm(Model model, @PathVariable("id")Long id) {
		model.addAttribute("book", mainService.findOneBook(id));
		return "editBook.jsp";
	}
	//edit
	@PutMapping("/books/{id}/edit")
	public String processEditBook(@Valid @ModelAttribute("book")Book book,
			BindingResult result) {
		if(result.hasErrors()) {
			return "editBook.jsp";
		}else {
			mainService.updateBook(book);
			return "redirect:/home";
		}
	} 
	
	//delete
	@DeleteMapping("/books/{id}/delete")
	public String deleteBook(@PathVariable("id")Long id) {
		mainService.deleteBook(id);
		return "redirect:/home";
	}
	
	//show one
	@GetMapping("/books/{id}")
	public String oneBook(@PathVariable("id")Long id, Model model) {
		Book oneBook = mainService.findOneBook(id);
		model.addAttribute("book",oneBook);
		return "showBook.jsp";
	}
	
	
} 
