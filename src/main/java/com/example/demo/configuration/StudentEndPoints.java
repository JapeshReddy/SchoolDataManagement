package com.example.demo.configuration;

public interface EndPoints
{
	 interface StudentEndPoints {

			String baseUrl="/api/students";
			String saveStudent=baseUrl;
			String updateStudent=baseUrl;
			String getAllStudents=baseUrl;
			String deleteStudent=baseUrl+"/{id}";
			String getStudentById=baseUrl+"/{id}";
			String getAllStudentsByClass=baseUrl+"/class";
			String getAllStudentsByClassAndSection=baseUrl+"/class_section";
			
		}
 }
