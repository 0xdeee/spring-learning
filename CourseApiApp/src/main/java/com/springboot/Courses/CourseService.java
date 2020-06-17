package com.springboot.Courses;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
//	List<Topics> topics = new ArrayList<Topics> (Arrays.asList(new Topics("java","Java Courses","All java courses will be here"),
//							 new Topics("angular","Angular Courses","All angular courses will be here"),
//							 new Topics("html","HTML Courses","All HTML courses will be here")
//							 ));
	
	@Autowired
	private CourseRepository courseRepository;
	public List<Courses> getAllCourses(String topicId){

		List<Courses> courses = new ArrayList<>();
		courseRepository.findByTopicTopicId(topicId).forEach(courses::add);
		return courses;
	}

	public Courses getSpecificCourse(String id) {

		return courseRepository.findById(id).get();
	}

	public void addCourse(Courses course) {

		courseRepository.save(course);
	}

	public void updateCourse(Courses course) {

		courseRepository.save(course);
	}

	public void deleteCourse(String id) {

		courseRepository.deleteById(id);
	}

}
