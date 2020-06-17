package com.springboot.Courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Courses, String> {
	
	public List<Courses> findByTopicTopicId(String topicId);

}
