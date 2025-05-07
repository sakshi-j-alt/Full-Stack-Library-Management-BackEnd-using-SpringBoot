package com.capgimini.project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Title is mandatory")
	private String title;

	@NotNull(message = "Author ID is mandatory")
	private Long authorId;

	@NotBlank(message = "Genre is mandatory")
	private String genre;

	@NotNull(message = "Total copies must be provided")
	@PositiveOrZero(message = "Total copies must be zero or positive")
	private Integer totalCopies;

	@NotNull(message = "Available copies must be provided")
	@PositiveOrZero(message = "Available copies must be zero or positive")
	private Integer availableCopies;

	public Book() {
		super();
	}

	public Book(String title, Long authorId, String genre, Integer totalCopies, Integer availableCopies) {
		super();
		this.title = title;
		this.authorId = authorId;
		this.genre = genre;
		this.totalCopies = totalCopies;
		this.availableCopies = availableCopies;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getTotalCopies() {
		return totalCopies;
	}

	public void setTotalCopies(Integer totalCopies) {
		this.totalCopies = totalCopies;
	}

	public Integer getAvailableCopies() {
		return availableCopies;
	}

	public void setAvailableCopies(Integer availableCopies) {
		this.availableCopies = availableCopies;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + id + ", title=" + title + ", authorId=" + authorId + ", genre=" + genre
				+ ", totalCopies=" + totalCopies + ", availableCopies=" + availableCopies + "]";
	}
}
