package com.example.demo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "student")
public class Student {
	
	@Id
	private String id;
	
	private String name;
	
	@Field(name = "mail")
	private String email;
	
	@DBRef
	private Department department;
	
	@DBRef
	private List<Subject> subjects;
	
	@Transient
	private double percentage;

	public double getPercentage() {
		
		if(null != subjects && subjects.size() > 0) {
			Integer total = subjects.stream().map(Subject :: getMarksObtained).reduce(0, Integer::sum);
//			Integer total1 = subjects.stream().mapToInt(Subject :: getMarksObtained).sum();			
			return total/ subjects.size();
		}
		return 0.00;
	}
}
