package com.example.demo.configuration;

public interface EndPoints {
	interface StudentEndPoints {

		String baseUrl = "/api/students";
		String deleteStudent = "/{id}";
		String getStudentById = "/{id}";
		String getAllStudentsByClass =  "/class";
		String getAllStudentsByClassAndSection = "/class_section";

	}

	interface ClassEndPoints {

		String baseUrl = "/api/class";
		String deleteClassByID =  "/{id}";
		String getClassById =  "/{id}";

		
	}

	interface MarksEndPoints {

		String baseUrl = "/api/marks";
		String deleteMarksByID = "/{id}";
		String getMarksById = "/{id}";
		String getMarksByStudentId ="/student/{id}";
		String getMarksBySubjectId ="/subject/{id}";
		String deleteMarksByStudentID ="/student/{id}";
		String deleteMarksBySubjectID = "subject/{id}";

	}
	interface SectionEndPoints {
		
		String baseUrl = "/api/section";
		String deleteSectionByID =  "/{id}";
		String getSectionById = "/{id}";
		String  getAllSectionByClassID = "/class/{id}";
		
	}
	interface SubjectEndPoints{
		String baseUrl = "/api/subject";
		String deleteSubjectByID =  "/{id}";
		String getSubjectById = "/{id}";
		String  getAllSubjectByClassID ="/class/{id}";
	}
}
