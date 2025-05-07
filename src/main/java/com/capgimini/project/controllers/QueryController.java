package com.capgimini.project.controllers;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgimini.project.entities.Query;
import com.capgimini.project.services.QueryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/query")
public class QueryController {
 private QueryService service;
@Autowired
public QueryController(QueryService service) {
	super();
	this.service = service;
}
@GetMapping("/status/{status}")
public ResponseEntity<List<Query>> getByStatus(@PathVariable String status){
	return ResponseEntity.status(HttpStatus.OK).body(service.getbySatus(status));
}
@GetMapping("/{id}")
public ResponseEntity<Query> getByID(@PathVariable Long id){
	return ResponseEntity.status(HttpStatus.OK).body(service.getbyID(id));
}
@GetMapping()
public ResponseEntity<List<Query>> getAll(){
	return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
}
@PatchMapping("/{id}")
public ResponseEntity<Query> updateByStatus(@PathVariable Long id){
    service.updateByStatus(id);
    Query updated = service.getbyID(id);
    return ResponseEntity.status(HttpStatus.OK).body(updated);
}

@PostMapping
public ResponseEntity<Query> createQuery(@Valid @RequestBody Query query){
	 query.setStatus("Not Resolved");
	return ResponseEntity.status(HttpStatus.CREATED).body(service.createQuery(query));
}
}
