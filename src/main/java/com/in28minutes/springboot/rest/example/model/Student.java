package com.in28minutes.springboot.rest.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 3, max = 8, message="El nombre debe de tener mínimo 3 carácteres y máximo 20")
	@Pattern(regexp = "[A-Za-z]+", message="El nombre solo puede contener letras")
	@NotEmpty(message="El nombre del estudiante es obligatorio")
	private String name;

	@Size(min = 5, max = 10, message="El pasaporte debe de tener mínimo 5 carácteres y máximo 10")
	@Pattern(regexp = "[A-Za-z0-9]+", message="El pasaporte solo puede contener letras y números")
	@NotEmpty(message="El pasaporte del estudiante es obligatorio")
	private String passportNumber;
	
	public Student() {
		super();
	}

	public Student(Long id, String name, String passportNumber) {
		super();
		this.id = id;
		this.name = name;
		this.passportNumber = passportNumber;
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
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
		
}
