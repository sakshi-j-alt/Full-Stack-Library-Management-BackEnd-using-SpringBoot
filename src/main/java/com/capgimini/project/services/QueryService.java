package com.capgimini.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgimini.project.entities.Query;

@Service
public interface QueryService {
	List<Query> getAll();
	List<Query> getbySatus(String status);
	Query getbyID (Long id);
	void updateByStatus(Long id);
	Query createQuery(Query query);
}
