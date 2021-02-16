package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.entity.Book;
import com.cts.service.BookService;

@Controller
public class LibraryController {

	@Autowired
	private BookService service;

	@GetMapping
	public String books(Model model) {
		model.addAttribute("books", service.getAllBooks());
		return "books";
	}

	@GetMapping("new-book")
	public String showBookForm(Model model) {
		model.addAttribute("book", new Book());
		return "new-book";
	}
	
	@PostMapping("add")
	public String addNewBook(@ModelAttribute Book book, Model model) {
		service.save(book);
		model.addAttribute("books", service.getAllBooks());
		return "books";
	}

}
