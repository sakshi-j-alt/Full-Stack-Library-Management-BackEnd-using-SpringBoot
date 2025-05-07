package com.capgimini.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgimini.project.entities.libraryUser;

public interface UserRepo extends JpaRepository<libraryUser, Long> {

}
