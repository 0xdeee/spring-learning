package com.springboot.Courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.topics.Topics;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Courses> getAllCourses(@PathVariable String topicId){
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping("/topics/{topicid}/courses/{id}")
	public Courses getSpecificTopic(@PathVariable String id) {
		return courseService.getSpecificCourse(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@PathVariable String topicId, @RequestBody Courses course) {
		course.setTopic(new Topics(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicid}/courses/{id}")
	public void updateCourse(@PathVariable String id, @RequestBody Courses course) {
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicid}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
}
