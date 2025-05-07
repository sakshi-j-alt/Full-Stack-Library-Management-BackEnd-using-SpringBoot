package com.capgimini.project.services;

import java.util.List;

import com.capgimini.project.entities.Book;

public interface BookService {
	List<Book> getAllBook();

	Book getBookById(Long id);

	Book createBook(Book stu);

	Book updateBook(Long id, Book book);

	Book patchBook(Long id, Book book);

	boolean deleteBook(Long id);
}
