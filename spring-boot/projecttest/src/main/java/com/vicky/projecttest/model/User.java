package com.vicky.projecttest.model;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;

@Entity
@Table(name="users")
public class User {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 @Size(min=1,message="First Name required")
	 private String firstName;
	 @Size(min=1, message="Last Name required")
	 private String lastName;
	 @Email(message="Email must be valid")
	 private String email;
	 @Size(min=1, message="Location Required")
	 private String location;
	 @Size(min=1, message="State Required")
	 private String state;
	 @Size(min=5, message="Password must be greater than 5 characters")
	 private String password;
	 @Transient
	 private String passwordConfirmation;
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 
	 @PrePersist
	 protected void onCreate(){
	     this.createdAt = new Date();
	 }
	 @PreUpdate
	 protected void onUpdate(){
	     this.updatedAt = new Date();
	 }   
	//Relationships
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	    	name = "users_ideas",
	    	joinColumns = @JoinColumn(name = "user_id"),
	    	inverseJoinColumns = @JoinColumn(name = "idea_id")
	    )
	    private List<Idea> likedideas;
	    
	    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
		private List<Idea> ideas;
	    

	    //Constructors
	    
	    public User() {
	    }
	    
	    public User(String firstName, String lastName, String email, String location, String password) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.location = location;
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
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
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
		public List<Idea> getLikedideas() {
			return likedideas;
		}
		public void setLikedideas(List<Idea> likedideas) {
			this.likedideas = likedideas;
		}
		public List<Idea> getIdeas() {
			return ideas;
		}
		public void setIdeas(List<Idea> ideas) {
			this.ideas = ideas;
		}
				

}

