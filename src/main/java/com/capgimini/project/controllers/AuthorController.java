package com.capgimini.project.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capgimini.project.entities.Author;
import com.capgimini.project.services.AuthorService;

import jakarta.validation.Valid;
@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/api/authors")
public class AuthorController {

	private AuthorService service;

	@Autowired
	public AuthorController(AuthorService service) {
		super();
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Author>> getAllAuthors() {
		List<Author> authors = service.getAllAuthor();
		return ResponseEntity.status(HttpStatus.OK).body(authors);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Author> getAuthor(@Valid @PathVariable Long id) {
		Author author = service.getAuthorById(id);
		return ResponseEntity.status(HttpStatus.OK).body(author);
	}

	@PostMapping
	public ResponseEntity<Author> createAuthor(@Valid @RequestBody Author author) {
		Author saved = service.createAuthor(author);
		return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("/api/authors/" + saved.getId()))
				.body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @Valid @RequestBody Author author) {
		Author updated = service.updateAuthor(id, author);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Author> patchAuthor(@PathVariable Long id, @Valid @RequestBody Author patch) {
		Author updated = service.patchAuthor(id, patch);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
		boolean deleted = service.deleteAuthor(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
