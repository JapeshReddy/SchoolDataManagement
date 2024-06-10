package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SectionDto {

	private int id;
	private String name;
	private int roomNumber;
	private short boysCount;
	private short girlsCount;
	private String className;
	private int academicYear;
}
