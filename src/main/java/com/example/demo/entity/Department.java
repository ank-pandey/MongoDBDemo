package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "department")
public class Department {
	
	@Id
	private String id;
	
	@Field(name = "department_name")
	private String departmentName;
	
	private String location;

}
