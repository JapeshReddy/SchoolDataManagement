package com.example.demo.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Marks;

public interface MarksRepositry extends JpaRepository<Marks, Integer> {

	@Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Marks m WHERE m.student_ref.id = :studentId AND m.subject_ref.id = :subjectId")
	boolean existsByStudentIdAndSubjectId(@Param("studentId") int studentId, @Param("subjectId") int subjectId);

	@Modifying
	@Query("DELETE FROM Marks m WHERE m.subject_ref.id = :subjectId")
	void deleteBySubjectId(int subjectId);

	@Modifying
	@Query("DELETE FROM Marks m WHERE m.student_ref.id = :studentId")
	void deleteMarksByStudentId(int studentId);

	@Query("SELECT m FROM Marks m WHERE m.student_ref.id = :studentId")
	List<Marks> findMarksByStudentId(@Param("studentId") int studentId);

	@Query("SELECT m FROM Marks m WHERE m.subject_ref.id = :subjectId")
	List<Marks> findMarksBySubjectId(@Param("subjectId") int subjectId);

	@Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END "
			+ "FROM Student s JOIN s.section_ref sec JOIN sec.class_ref c JOIN c.subjects sub "
			+ "WHERE s.id = :studentId AND sub.id = :subjectId")
	boolean doStudentAndSubjectBelongToSameClass(@Param("studentId") int studentId, @Param("subjectId") int subjectId);

}
