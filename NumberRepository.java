package com.glaucus.Counter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface NumberRepository extends JpaRepository<Number,Integer> {
	
	
	 @Query("SELECT n from Number n where n.count =:count ")       // using @query
	 List<Number> findByCount(@Param("count") Integer count);
}
