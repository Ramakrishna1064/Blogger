package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.Blogs;
import com.example.demo.dto.Category;
import com.example.demo.repository.BlogRepository;
import com.example.demo.repository.CategoryRepository;

@RestController 
public class SampleController1 {

	
	@Autowired
	BlogRepository blogRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@RequestMapping("/blog-list")
	@ResponseBody
	public List<Blogs> getAllBlogs(){
		List<Blogs>blogsList = blogRepository.findAll();
		return blogsList;
	}
	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/future-blog-list")
	@ResponseBody
	public List<Blogs> getFutureBlogs(){
		List<Blogs>blogsList = blogRepository.findByIsFeatured(1);
		return blogsList;
	}
	
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/blog-list-byId")
	@ResponseBody
	public Blogs getUserById(@RequestParam int id){
		Blogs blog = blogRepository.findById(id);
		return blog;
	}
	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/recent-blog-list")
	@ResponseBody
	public List<Blogs> getRecentBlogs(){
		List<Blogs>blogsList = blogRepository.findByIsFeatured(0);
		return blogsList;
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/category-list")
	@ResponseBody
	public List<Category> getCategoryList(){
		List<Category>categoryList = categoryRepository.findAll();
		return categoryList;
	}
	
	
	/**
	 * updateFoos
	 * @param allParams
	 * @return
	 */
	@PostMapping("/foos")
	@ResponseBody
	public String updateFoos(@RequestParam Map<String,String> allParams) {
	    return "Parameters are " + allParams.entrySet();
	}
	
}