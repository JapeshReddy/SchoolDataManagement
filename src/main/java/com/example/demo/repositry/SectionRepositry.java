package com.example.demo.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Section;

public interface SectionRepositry extends JpaRepository<Section, Integer> {

	List<Section> findByRoomNumberAndIdNot(int roomNumber, int id);

	@Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM Section s WHERE s.name = :name AND s.class_ref = :classRef")
	boolean existsByNameAndClassRef(@Param("name") String name,
			@Param("classRef") com.example.demo.entity.Class classRef);

	@Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM Section s WHERE s.name = :name AND s.class_ref = :classRef AND s.id != :id")
	boolean existsByNameAndClassRefAndIdNot(@Param("name") String name,
			@Param("classRef") com.example.demo.entity.Class classRef, int id);

	boolean existsByRoomNumber(int roomNumber);
}
