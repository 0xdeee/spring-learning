package com.springboot.topics;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
//	List<Topics> topics = new ArrayList<Topics> (Arrays.asList(new Topics("java","Java Courses","All java courses will be here"),
//							 new Topics("angular","Angular Courses","All angular courses will be here"),
//							 new Topics("html","HTML Courses","All HTML courses will be here")
//							 ));
	
	@Autowired
	private TopicRepository topicRepository;
	public List<Topics> getAllTopics(){

		List<Topics> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Topics getSpecificTopic(String id) {

		return topicRepository.findById(id).get();
	}

	public void addTopic(Topics topic) {

		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topics topic) {

		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {

		topicRepository.deleteById(id);
	}

}
