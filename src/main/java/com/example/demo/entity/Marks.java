package com.example.demo.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Marks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "marks_id")
	@JsonIgnore
	private int id;
	@Column(nullable = false)
	private byte marks;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date examDate;
	@ManyToOne
	@JoinColumn(name = "student_id")
	@JsonIgnore
	private Student student_ref;
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject_ref;
	
	
	

}
