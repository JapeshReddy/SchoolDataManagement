package com.example.demo.entity;

import java.util.List;

import com.example.demo.listner.SectionListener;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(SectionListener.class)
public class Section {

	@Id
	@JsonIgnore
	@Column(name = "section_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, name = "section_name")
	private String name;
	@Column(name = "room_number", unique = true)
	private int roomNumber;
	@JsonIgnore
	@Column(name = "boys_count")
	private short boysCount;
	@JsonIgnore
	@Column(name = "girls_count")
	private short girlsCount;
	@ManyToOne
	@JoinColumn(name = "class_id")
	@JsonIgnore
	private Class class_ref;
	@JsonIgnore
	@OneToMany(mappedBy = "section_ref", cascade = CascadeType.ALL)
	private List<Student> students;

}
