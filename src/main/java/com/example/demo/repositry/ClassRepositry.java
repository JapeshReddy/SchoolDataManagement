package com.example.demo.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClassRepositry extends JpaRepository<com.example.demo.entity.Class, Integer> {
	boolean existsByNameAndAcademicYear(String name, int year);

	boolean existsByNameAndAcademicYearAndIdNot(String name, int academicYear, int id);

	List<com.example.demo.entity.Class> findByAcademicYear(int year);

	boolean existsByAcademicYear(int year);

	@Modifying
	@Query("UPDATE Class c SET c.sectionsCount = c.sectionsCount + 1 WHERE c.id = :classId")
	void incrementSectionsCount(@Param("classId") int classId);

	@Modifying
	@Query("UPDATE Class c SET c.sectionsCount = c.sectionsCount - 1 WHERE c.id = :classId")
	void decrementSectionsCount(@Param("classId") int classId);

	@Modifying
	@Query("UPDATE Class c SET c.boysCount = c.boysCount + 1 WHERE c.id = :classId")
	void incrementBoysCount(@Param("classId") int classId);

	@Modifying
	@Query("UPDATE Class c SET c.boysCount = c.boysCount - 1 WHERE c.id = :classId")
	void decrementBoysCount(@Param("classId") int classId);

	@Modifying
	@Query("UPDATE Class c SET c.girlsCount = c.girlsCount + 1 WHERE c.id = :classId")
	void incrementGirlsCount(@Param("classId") int classId);

	@Modifying
	@Query("UPDATE Class c SET c.girlsCount = c.girlsCount - 1 WHERE c.id = :classId")
	void decrementGirlsCount(@Param("classId") int classId);
}
