package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.Blogs;

public interface BlogRepository extends JpaRepository<Blogs, Integer> {  
	List<Blogs> findByIsFeatured(int featureId);
	Blogs findById(int id);
}
