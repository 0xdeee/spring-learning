package com.springboot.topics;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "topics")
@EntityListeners(AuditingEntityListener.class)
public class Topics {
	
	@Id
	private String topicId;
	private String topicName;
	private String topicDesc;
	public Topics(String topicId, String topicName, String topicDesc) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
		this.topicDesc = topicDesc;
	}
	public Topics() {
		
	}
	public String getTopicId() {
		return topicId;
	}
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getTopicDesc() {
		return topicDesc;
	}
	public void setTopicDesc(String topicDesc) {
		this.topicDesc = topicDesc;
	}
	

}
