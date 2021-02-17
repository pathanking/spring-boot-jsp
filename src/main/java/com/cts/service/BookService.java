package com.cts.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

	public void save(Book book) {
		repository.save(book);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public void update(@Valid Book book) {
		repository.save(book);
	}

	public Book findById(Long id) {
		Optional<Book> bk = repository.findById(id);
		if(bk.isPresent())
			return bk.get();
		else
			return new Book();
	}

}
