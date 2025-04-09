package com.example.pb.social_media.User;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class UserPosts {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne (fetch = FetchType.LAZY)
	//@JsonIgnore
	private User user;
	
	private String message;
	
	public UserPosts() { }

	
	public UserPosts(Long id, User user, String message) {
		super();
		this.id = id;
		this.user = user;
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
