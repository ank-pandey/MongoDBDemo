package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.SubjectRepository;

@Service
public class MongoDBDemoService {
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	DepartmentRepository deptRepo;
	
	@Autowired
	SubjectRepository subjectRepo;

	public Student createStudent(Student student) {
		
		if(null != student.getDepartment()) {
			deptRepo.save(student.getDepartment());
		}
		if(null != student.getSubjects() && student.getSubjects().size() > 0) {
			subjectRepo.saveAll(student.getSubjects());
		}
		return studentRepo.save(student);
		
	}

	public Student getStudentById(String id) {
		
		return studentRepo.findById(id).get();
	}

	public List<Student> getAll() {
		
		return studentRepo.findAll();
	}

	public Student updateStudent(Student student) {
		
		return studentRepo.save(student);
	}

	public String deleteStudent(String id) {
		studentRepo.deleteById(id);
		return "Student record is deleted successfully!!";
	}

	public List<Student> getStudentsByName(String name) {
		return studentRepo.findByName(name);
	}

	public List<Student> getStudentsByNameAndEmail(String name, String email) {
		return studentRepo.findByNameAndEmail(name, email);
	}

	public List<Student> getStudentsByNameOrEmail(String name, String email) {
		return studentRepo.findByNameOrEmail(name, email);
	}

	public List<Student> getStudentsByPagination(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return studentRepo.findAll(pageable).getContent();
	}

	public List<Student> getStudentsBySorting() {
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		return studentRepo.findAll(sort);
	}

	public List<Student> getStudentsByDepartmentName(String deptName) {
		return studentRepo.findByDepartmentDepartmentName(deptName);
	}

}
