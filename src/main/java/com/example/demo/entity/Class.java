package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Class {

	@Id
	@JsonIgnore
	@Column(name = "class_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = true)
	private String name;
	@Column(name = "academic_years", nullable = false)
	private short academicYear;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "class_ref")
	private List<Section> sections;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "class_ref")
	private List<Subject> subjects;
}
