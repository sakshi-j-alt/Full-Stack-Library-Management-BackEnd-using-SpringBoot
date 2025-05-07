package com.capgimini.project.services;

import java.util.List;
import java.util.Map;

import com.capgimini.project.entities.Book;

public interface BookService {
	List<Book> getAllBook();

	Book getBookById(Long id);

	Book createBook(Book stu);

	Book updateBook(Long id, Book book);

	Book patchBook(Long id, Book book);

	boolean deleteBook(Long id);
	
	public Book updateAvailableCopies(Long id, Map<String, Object> updates);
}
