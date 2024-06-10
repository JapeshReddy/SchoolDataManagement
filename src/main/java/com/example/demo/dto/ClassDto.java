package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassDto {

	private int id;
	private String name;
	private byte sectionCount;
	private short boysCount;
	private short girlsCount;
	private short academicYear;
	
}
