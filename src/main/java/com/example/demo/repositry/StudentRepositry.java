package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Student;

public interface StudentRepositry extends JpaRepository<Student, Integer> {

	boolean existsByEmail(String email);

	@Query("SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM Student s WHERE s.email = :email AND s.id != :id")
	boolean existsByEmailAndIdNot(@Param("email") String email, @Param("id") int id);
}
