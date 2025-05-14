package com.capgimini.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgimini.project.entities.Query;
import com.capgimini.project.repositories.QueryRepository;

@Service
public class QueryServiceImpl implements QueryService{
	private QueryRepository repo;
	@Autowired
	public QueryServiceImpl(QueryRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Query> getAll() {
		
		return repo.findAll();
	}

	@Override
	public Query getbyID(Long id) {
		
		return repo.findById(id).orElseThrow();
	}

	@Override
	public void updateByStatus(Long id) {
	    Query query = repo.findById(id).orElseThrow();
	    if ("Not Resolved".equalsIgnoreCase(query.getStatus())) {
	        query.setStatus("Resolved");
	        repo.save(query); 
	    }
	}

	@Override
	public List<Query> getbySatus(String status) {
		return repo.findByStatus(status);
	}
	
	@Override
	public Query createQuery(Query query) {
		
		return repo.save(query);
	}
	
}
