package com.capgimini.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capgimini.project.entities.Book;
import com.capgimini.project.services.BookService;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

	private BookService service;

	@Autowired
	public BookController(BookService service) {
		super();
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = service.getAllBook();
		return ResponseEntity.status(HttpStatus.OK).body(books);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@Valid @PathVariable Long id) {
		Book book = service.getBookById(id);
		return ResponseEntity.status(HttpStatus.OK).body(book);
	}

	@PostMapping
	public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
		Book saved = service.createBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("/api/books/" + saved.getBookId()))
				.body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody Book book) {
		Book updated = service.updateBook(id, book);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Book> patchBook(@PathVariable Long id, @Valid @RequestBody Book patch) {
		Book updated = service.patchBook(id, patch);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		boolean deleted = service.deleteBook(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
