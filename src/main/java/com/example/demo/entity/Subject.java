package com.example.demo.entity;

import java.util.List;

import com.example.demo.listner.SubjectListner;
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
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(SubjectListner.class)
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subject_id")
	@JsonIgnore
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String code;
	private byte credits;
	@ManyToOne
	@JoinColumn(name = "class_id")
	@JsonIgnore
	private Class class_ref;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "subject_ref")
	@JsonIgnore
	private List<Marks> marks;


}
