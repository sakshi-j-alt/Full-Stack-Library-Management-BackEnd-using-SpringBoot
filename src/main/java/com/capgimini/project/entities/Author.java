package com.capgimini.project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name is mandatory")
	private String name;

	@NotBlank(message = "Bio is mandatory")
	private String bio;

	public Author() {
		super();
	}

	public Author(String name, String bio) {
		super();
		this.name = name;
		this.bio = bio;
	}

	public Long getId() {
		return id;
	}

	public void setAuthorId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + id + ", name=" + name + ", bio=" + bio + "]";
	}
}
