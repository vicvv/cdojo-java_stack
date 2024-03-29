package com.vicky.admindashboard.models;


import java.util.Date;
//import java.util.List;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.Size;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
@Entity
@Table(name="users")
public class User {
 
	 @Id
	 @GeneratedValue
	 private Long id;
	 @Size(min=2, message="First name must be greater than 2 characters")
	 private String firstName;
	 @Size(min=2, message="Last name must be greater than 2 characters")
	 private String lastName;
	 @Email(message="Email must be valid")
	 private String username;
	
	 @Size(min=5, message="Password must be greater than 5 characters")
	 private String password;
	 @Transient
	 private String passwordConfirmation;
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 
	 @ManyToMany(fetch = FetchType.EAGER)
	 @JoinTable(
	     name = "users_roles", 
	     joinColumns = @JoinColumn(name = "user_id"), 
	     inverseJoinColumns = @JoinColumn(name = "role_id"))
	 private List<Role> roles;
	 
	 public User() {
	 }
	 
	 public User(String firstName, String lastName,String username, String password) {
		 this.firstName = firstName;
		 this.lastName = lastName;
		 this.username = username;
		 this.password = password;
	 }
 
 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> list) {
		this.roles = list;
	}

	@PrePersist
	 protected void onCreate(){
	     this.createdAt = new Date();
	 }
	 @PreUpdate
	 protected void onUpdate(){
	     this.updatedAt = new Date();
	 
	}
}