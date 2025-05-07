package com.capgimini.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgimini.project.entities.Query;

public interface QueryRepository extends JpaRepository<Query, Long>{
	List<Query> findByStatus(String status); 

}
