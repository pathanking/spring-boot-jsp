package com.cts.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String addNewBook(@Valid @ModelAttribute Book book, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "new-book";
		}

		service.save(book);
		model.addAttribute("books", service.getAllBooks());
		return "books";
	}

	@PostMapping("{id}/delete")
	public String delete(@PathVariable Long id, Model model) {
		service.deleteById(id);

		model.addAttribute("books", service.getAllBooks());
		return "books";
	}

	@PostMapping("{id}")
	public String editBookById(@PathVariable Long id, Model model) {
		Book book = service.findById(id);
		model.addAttribute("book", book);
		return "edit-book";

	}

	@PostMapping("{id}/update")
	public String update(@PathVariable Long id, @Valid @ModelAttribute Book book,  BindingResult result,Model model) {

		if (result.hasErrors())
			return "edit-book";

		service.update(book);

		model.addAttribute("books", service.getAllBooks());

		return "books";
	}

}
