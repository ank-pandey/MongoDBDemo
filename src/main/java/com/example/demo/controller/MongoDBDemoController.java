package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.MongoDBDemoService;

@RestController
@RequestMapping("/api/student")
public class MongoDBDemoController {
	
	@Autowired
	MongoDBDemoService mongoService;
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return mongoService.createStudent(student);
				
	}
	
	@GetMapping("/getById/{id}")
	public Student getStudentById(@PathVariable String id) {
		return mongoService.getStudentById(id);
	}
	
	@GetMapping("/getByStudentName/{name}")
	public List<Student> getStudentsByName(@PathVariable String name) {
		return mongoService.getStudentsByName(name);
	}
	
	@GetMapping("/getByStudentNameAndMail")
	public List<Student> getStudentsByNameAndMail(@RequestParam String name, @RequestParam String email) {
		return mongoService.getStudentsByNameAndEmail(name, email);
	}
	
	@GetMapping("/getByStudentNameOrMail")
	public List<Student> getStudentsByNameOrMail(@RequestParam String name, @RequestParam String email) {
		return mongoService.getStudentsByNameOrEmail(name, email);
	}
	
	@GetMapping("/getByPagination")
	public List<Student> getStudentsByPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
		return mongoService.getStudentsByPagination(pageNo, pageSize);
	}
	
	@GetMapping("/getBySorting")
	public List<Student> getStudentsBySorting() {
		return mongoService.getStudentsBySorting();
	}
	
	@GetMapping("/getByDepartmentName")
	public List<Student> getStudentsByDepartmentName(@RequestParam String deptName) {
		return mongoService.getStudentsByDepartmentName(deptName);
	}
	
	@GetMapping("/retrieveAll")
	public List<Student> findAll(){
		return mongoService.getAll();
	}
	
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		return mongoService.updateStudent(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable String id) {
		return mongoService.deleteStudent(id);
	}

}