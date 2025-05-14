package com.capgimini.project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Query {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	@NotBlank(message = "User name is mandatory")
	protected String name;
	@NotNull(message = "UserId is mandatory")
	protected Long userId;
	@NotBlank(message = "Subject is mandatory")
	protected String subject;
	@NotBlank(message = "Message is mandatory")
	protected String message;
	protected String status;
	public Query(Long id, @NotBlank(message = "User name is mandatory") String name,
			@NotBlank(message = "UserId is mandatory") Long userId,
			@NotBlank(message = "Subject is mandatory") String subject,
			@NotBlank(message = "Message is mandatory") String message, String status) {
		super();
		this.id = id;
		this.name = name;
		this.userId = userId;
		this.subject = subject;
		this.message = message;
		this.status= status;
	}
	public Query() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Query [id=" + id + ", name=" + name + ", userId=" + userId + ", subject=" + subject + ", message="
				+ message +", Status="+status+ "]";
	}
	
	
	
	
}
