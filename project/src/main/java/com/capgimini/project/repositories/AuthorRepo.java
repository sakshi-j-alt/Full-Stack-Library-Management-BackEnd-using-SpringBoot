package com.capgimini.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgimini.project.entities.Author;

public interface AuthorRepo extends JpaRepository<Author, Long> {

}
