package com.springboot.Courses;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.springboot.topics.Topics;

@Entity
@Table(name = "course")
@EntityListeners(AuditingEntityListener.class)
public class Courses {
	
	@Id
	private String courseId;
	private String courseName;
	private String courseDesc;
	@ManyToOne
	private Topics topic;
	public Courses(String courseId, String courseName, String courseDesc, String topicId) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDesc = courseDesc;
		this.topic = new Topics(topicId,"","");
	}
	public Courses() {
		
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDesc() {
		return courseDesc;
	}
	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}
	public Topics getTopic() {
		return topic;
	}
	public void setTopic(Topics topic) {
		this.topic = topic;
	}
	
	

}
