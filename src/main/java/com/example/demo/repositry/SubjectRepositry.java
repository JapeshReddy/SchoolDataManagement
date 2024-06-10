package com.example.demo.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Subject;

public interface SubjectRepositry extends JpaRepository<Subject, Integer> {

	@Query("SELECT COUNT(s) > 0 FROM Subject s WHERE s.name = :name AND s.class_ref.id = :classId")
	boolean existsByNameAndClassId(@Param("name") String name, @Param("classId") int classId);

	boolean existsByCode(String code);

	@Query("SELECT s FROM Subject s WHERE s.class_ref.id = :classId")
	List<Subject> findSubjectsByClassId(@Param("classId") int classId);

	@Query("SELECT COUNT(s) > 0 FROM Subject s WHERE s.class_ref.id = :classId AND s.name = :name AND s.id <> :subjectId")
	boolean existsByNameAndClassRefAndIdNot(@Param("classId") int classId, @Param("name") String name,
			@Param("subjectId") int subjectId);

	@Query("SELECT COUNT(s) > 0 FROM Subject s WHERE s.code = :code AND s.id != :id")
	boolean existsByCodeAndNotId(@Param("code") String code, @Param("id") int id);

	@Query("SELECT COUNT(s) > 0 FROM Subject s WHERE s.class_ref.id = :classId AND s.id = :subjectId")
	boolean existsByClassIdAndSubjectId(@Param("classId") int classId, @Param("subjectId") int subjectId);
}
