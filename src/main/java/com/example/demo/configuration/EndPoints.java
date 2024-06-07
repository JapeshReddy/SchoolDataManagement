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
		String saveMarks = baseUrl;
		String updateMarks = baseUrl;
		String deleteMarksByID = baseUrl + "/{id}";
		String getMarksById = baseUrl + "/{id}";
		String getMarksByStudentId = baseUrl+"/student/{id}";
		String getMarksBySubjectId = baseUrl+"/subject/{id}";
		String deleteMarksByStudentID = baseUrl+"/student/{id}";
		String deleteMarksBySubjectID = baseUrl+"/subject/{id}";

	}
	interface SectionEndPoints {
		
		String baseUrl = "/api/section";
		String saveSection = baseUrl;
		String updateSection = baseUrl;
		String deleteSectionByID = baseUrl + "/{id}";
		String getSectionById = baseUrl + "/{id}";
		String  getAllSectionByClassID = baseUrl+"/class/{id}";
		
	}
	interface SubjectEndPoints{
		String baseUrl = "/api/subject";
		String saveSubject = baseUrl;
		String updateSubject = baseUrl;
		String deleteSubjectByID = baseUrl + "/{id}";
		String getSubjectById = baseUrl + "/{id}";
		String  getAllSubjectByClassID = baseUrl+"/class/{id}";
	}
}
