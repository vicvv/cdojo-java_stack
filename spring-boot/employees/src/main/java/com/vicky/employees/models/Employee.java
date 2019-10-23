package com.vicky.employees.models;

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
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;


@Entity
@Table(name="employees")
	public  class Employee {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String first_name;
	    private String last_name;
	  
	    
	 // This will not allow the createdAt column to be updated after creation
	    @Column(updatable=false)
	    
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;

	    
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	    name = "relationship", 
	    joinColumns = @JoinColumn(name = "user_id"), 
	    inverseJoinColumns = @JoinColumn(name = "manager_id")
	    )
	    private List<Employee> relationship;
	    
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	    name = "relationship", 
	    joinColumns = @JoinColumn(name = "manager_id"), 
	    inverseJoinColumns = @JoinColumn(name = "user_id")
	    )
	    	    
	    private List<Employee> employeeManager;
	    
	    
	    public Employee() {
	    }
	    public Employee(String first_name, String last_name) {
	    	
	    	this.first_name = first_name;
	    	this.last_name = last_name;
	    	
	    }
	    
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFirst_name() {
			return first_name;
		}
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		public String getLast_name() {
			return last_name;
		}
		public void setLast_name(String last_name) {
			this.last_name = last_name;
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
		
		public List<Employee> getRelationship() {
			return relationship;
		}
		public void setRelationship(List<Employee> relationship) {
			this.relationship = relationship;
		}
		public List<Employee> getEmployeeManager() {
			return employeeManager;
		}
		public void setEmployeeManager(List<Employee> employeeManager) {
			this.employeeManager = employeeManager;
		}   
	    
	    
	    
		    
}


