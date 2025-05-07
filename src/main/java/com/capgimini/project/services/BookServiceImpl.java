package com.capgimini.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgimini.project.entities.Book;
import com.capgimini.project.exceptions.BookNotFoundException;
import com.capgimini.project.repositories.BookRepo;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

	private BookRepo bookRepo;

	@Autowired
	public BookServiceImpl(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}

	@Override
	public List<Book> getAllBook() {
		return bookRepo.findAll();
	}

	@Override
	public Book getBookById(Long id) {
		return bookRepo.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found with book id " + id));
	}

	@Override
	public Book createBook(@Valid Book book) {
		return bookRepo.save(book);
	}

	@Override
	public Book updateBook(Long id, Book book) {
		Optional<Book> optional = bookRepo.findById(id);
		if (optional.isPresent()) {
			Book existing = optional.get();
			existing.setTitle(book.getTitle());
			existing.setAuthorId(book.getAuthorId());
			existing.setGenre(book.getGenre());
			existing.setTotalCopies(book.getTotalCopies());
			existing.setAvailableCopies(book.getAvailableCopies());
			return bookRepo.save(existing);
		}
		return null;
	}

	@Override
	public Book patchBook(Long id, Book book) {
		Optional<Book> optional = bookRepo.findById(id);
		if (optional.isPresent()) {
			Book existing = optional.get();
			if (book.getTitle() != null) {
				existing.setTitle(book.getTitle());
			}
			if (book.getAuthorId() != null) {
				existing.setAuthorId(book.getAuthorId());
			}
			if (book.getGenre() != null) {
				existing.setGenre(book.getGenre());
			}
			if (book.getTotalCopies() != null) {
				existing.setTotalCopies(book.getTotalCopies());
			}
			if (book.getAvailableCopies() != null) {
				existing.setAvailableCopies(book.getAvailableCopies());
			}
			return bookRepo.save(existing);
		}
		return null;
	}

	@Override
	public boolean deleteBook(Long id) {
		if (bookRepo.existsById(id)) {
			bookRepo.deleteById(id);
			return true;
		}
		return false;
	}
	
	@Override
	public Book updateAvailableCopies(Long id, Map<String, Object> updates) {
	    Book book = getBookById(id);
	    if (updates.containsKey("availableCopies")) {
	        book.setAvailableCopies((Integer) updates.get("availableCopies"));
	    }
	    return bookRepo.save(book);
	}

}
