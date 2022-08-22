package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collation = "subject")
public class Subject {

	@Id
	private String id;
	
	@Field(name = "subject_name")
	private String subjectName;
	
	@Field(name = "marks_obtained")
	private int marksObtained;
}
