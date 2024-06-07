package com.example.demo.entity;

import java.sql.Time;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Section {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "section_id")
	private int id;
	@Column(nullable = false, name = "section_name")
	private String name;
	@Column(name = "room_number",unique = true)
	private int roomNumber;
	@ManyToOne
	@JoinColumn(name = "class_id")
	@JsonIgnore
	private Class class_ref;
	@OneToMany(mappedBy = "section_ref", cascade = CascadeType.ALL)
	private List<Student> students;

}
