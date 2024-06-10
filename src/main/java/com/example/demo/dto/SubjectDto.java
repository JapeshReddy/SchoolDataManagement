package com.example.demo.dto;

import com.example.demo.entity.Subject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDto {

	private int id;
	private String name;
	private String code;
	private byte credits;
	private String className;
	
	
	
	public SubjectDto(Subject s) {
		this.id=s.getId();
		this.name=s.getName();
		this.credits=s.getCredits();
		this.code=s.getCode();
	}


}
