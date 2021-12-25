package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Student;
import com.example.demo.exception.IdNotFound;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping(value="/student")
public class StudentController
{	
@Autowired
StudentRepository repo;
	@PostMapping("/addstudent")
	public String addStudent(@RequestBody Student s)
	{
		repo.save(s);
		return "Student Record saved successfully with id"+s.getId()+"!!!";
	}
	
	
	@GetMapping("/getstudent/{id}")
	public Student getStudent(@PathVariable int id) throws IdNotFound
	{
		Student s=null;
		Optional<Student> stud = repo.findById(id);
		if(stud.isPresent())
		{
			s=stud.get();
			return s;
		}
		throw new IdNotFound("Student Record for this id didn't found..!");	
	}
	
	@DeleteMapping("/deletestudent/{id}")
	public String deleteStudent(@PathVariable int id)
	{
		Optional<Student> stud=repo.findById(id);
		if(stud.isPresent())
		{
			repo.deleteById(id);
			return "Student deleted successfully for id"+id;	
		}
		return "Student Didn't found for Id"+id;	
	}
}
