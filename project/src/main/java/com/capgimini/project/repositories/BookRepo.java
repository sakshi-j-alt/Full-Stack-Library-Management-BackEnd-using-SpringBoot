package com.capgimini.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgimini.project.entities.Book;

public interface BookRepo extends JpaRepository<Book, Long> {

}
