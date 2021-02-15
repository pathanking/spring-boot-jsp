package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Book;
import com.cts.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	public List<Book> getAllBooks() {
		return repository.findAll();
	}

}
