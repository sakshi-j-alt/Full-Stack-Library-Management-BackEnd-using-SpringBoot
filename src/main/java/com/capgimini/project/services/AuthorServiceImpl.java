package com.capgimini.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgimini.project.entities.Author;
import com.capgimini.project.exceptions.AuthorNotFoundException;
import com.capgimini.project.repositories.AuthorRepo;

import jakarta.validation.Valid;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepo authorRepo;

    @Autowired
    public AuthorServiceImpl(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepo.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepo.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Author not found with author id " + id));
    }

    @Override
    public Author createAuthor(@Valid Author author) {
        return authorRepo.save(author);
    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        Optional<Author> optional = authorRepo.findById(id);
        if (optional.isPresent()) {
            Author existing = optional.get();
            existing.setName(author.getName());
            existing.setBio(author.getBio());
            return authorRepo.save(existing);
        }
        return null;
    }

    @Override
    public Author patchAuthor(Long id, Author author) {
        Optional<Author> optional = authorRepo.findById(id);
        if (optional.isPresent()) {
            Author existing = optional.get();
            if (author.getName() != null) {
                existing.setName(author.getName());
            }
            if (author.getBio() != null) {
                existing.setBio(author.getBio());
            }
            return authorRepo.save(existing);
        }
        return null;
    }

    @Override
    public boolean deleteAuthor(Long id) {
        if (authorRepo.existsById(id)) {
            authorRepo.deleteById(id);
            return true;
        }
        return false;
    }
}

