package com.example.demo.entity;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringExclude;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Class {

	@Id
	@JsonIgnore
	@Column(name = "class_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(name = "academic_years", nullable = false)
	private short academicYear;
	@JsonIgnore
	@Column(name = "boys_count")
	private short boysCount;
	@JsonIgnore
	@Column(name = "girls_count")
	private short girlsCount;
	@JsonIgnore
	@Column(name = "sections_count")
	private byte sectionsCount;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "class_ref")
	@ToStringExclude
	private List<Section> sections;
	@JsonIgnore
	@ToStringExclude
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "class_ref")
	private List<Subject> subjects;
}
