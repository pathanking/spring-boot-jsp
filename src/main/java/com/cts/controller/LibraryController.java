package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
