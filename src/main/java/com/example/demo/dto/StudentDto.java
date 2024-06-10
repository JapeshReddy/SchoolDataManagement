package com.example.demo.dto;

import java.sql.Date;
import java.util.Map;

import com.example.demo.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

	private int id;
	private String name;
	private String phoneNo;
	private Date dob;
	private char gender;
	private String address;
	private String email;
	private String className;
	private String sectionName;
	private int academicTear;
	private Map<String, Byte> marks;
	public StudentDto(Student student) {
		super();
		this.id = student.getId();
		this.name = student.getName();
		this.phoneNo = student.getPhoneNo();
		this.dob = student.getDob();
		this.gender = student.getGender();
		this.address = student.getAddress();
		this.email = student.getEmail();
	}
	
	
	
	

}
