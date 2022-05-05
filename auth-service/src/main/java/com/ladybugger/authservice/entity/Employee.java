package com.ladybugger.authservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.*;


import java.sql.Date;
import lombok.Builder;
import lombok.Data;


@Data
@Entity
@Table(name = "employee", uniqueConstraints = {
		@UniqueConstraint(columnNames = "email")
})

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

	private String name;
	private String middleName;
	private String lastName;

	private Date startDate;

	private int status;
        
        private String role;



	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	

	public Employee() {

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Employee(@NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(max = 120) String password,
			String name, String middleName, String lastName, Date startDate, int status,String role) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.middleName = middleName;
		this.lastName = lastName;
		this.startDate = startDate;
		this.status = status;
                this.role=role;
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

}