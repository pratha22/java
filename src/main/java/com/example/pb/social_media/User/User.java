package com.example.pb.social_media.User;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity (name = "user_details")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min=2)
	private String name;
	
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Past
    private LocalDate birthdate;
    
    @OneToMany (mappedBy = "user")
    private List<UserPosts> userPosts;
    
    public List<UserPosts> getUserPosts() {
		return userPosts;
	}

	public void setUserPosts(List<UserPosts> userPosts) {
		this.userPosts = userPosts;
	}

	public User() {}
	
	public User(int id, String name, LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}
	@Override
	public boolean equals(Object obj) {
		User user = (User)obj;		
		if(user.id == this.id) return true;
		return false;
		}
	
	

}
