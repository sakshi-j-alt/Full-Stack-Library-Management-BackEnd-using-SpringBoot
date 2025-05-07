package com.capgimini.project.services;

import java.util.List;

import com.capgimini.project.entities.Author;

public interface AuthorService {
	List<Author> getAllAuthor();

	Author getAuthorById(Long id);

	Author createAuthor(Author author);

	Author updateAuthor(Long id, Author author);

	Author patchAuthor(Long id, Author author);

	boolean deleteAuthor(Long id);
}
