package com.alexismayoral.dojosandninjas.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name="ninjas")
public class Ninja {
	
		//id
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	 	@NotEmpty
	    private String firstName;
	    
	 	@NotEmpty
	    private String lastName;
	    
	 	@Positive
	    private int age;
	    @Column(updatable=false)
	    
	    private Date createdAt;
	    
	    private Date updatedAt;
	    
	    @NotNull
	    // joining tables
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="dojo_id")
	    private Dojo dojo;
	    
	    //constructor
	    public Ninja() {
	        
	    }
	    
	    // getters and setters
	    
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



		public int getAge() {
			return age;
		}



		public void setAge(int age) {
			this.age = age;
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



		public Dojo getDojo() {
			return dojo;
		}



		public void setDojo(Dojo dojo) {
			this.dojo = dojo;
		}



		//update and create
		@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
}
