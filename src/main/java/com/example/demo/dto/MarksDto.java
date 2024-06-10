package com.example.demo.dto;

import java.sql.Date;

import com.example.demo.entity.Marks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarksDto {

	private int id;
	private byte marks;
	private byte credits;
	private Date examDate;
	private String studentName;
	private String subjectName;
	private String subjectCode;

	public MarksDto(Marks m) {

		this.id = m.getId();
		this.marks = m.getMarks();
		this.examDate = m.getExamDate();
	}

}
