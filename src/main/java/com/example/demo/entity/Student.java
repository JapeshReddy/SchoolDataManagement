package com.example.demo.entity;

import java.sql.Date;
import java.util.List;

import com.example.demo.listner.StudentListner;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(StudentListner.class)
public class Student {

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(name = "phone_number", nullable = false)
	private String phoneNo;
	@Schema(type = "string", format = "date", example = "2023-12-31")
	@Column(name = "date_of_birth", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Column(nullable = false)
	private char gender;
	@Column(nullable = false)
	private String address;
	@Column(unique = true)
	private String email;
	@ManyToOne
	@JoinColumn(name = "section_id")
	@JsonIgnore
	private Section section_ref;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student_ref")
	@JsonIgnore
	private List<Marks> marks;

	
	
	
}
