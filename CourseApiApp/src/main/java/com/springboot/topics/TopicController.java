package com.springboot.topics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
//	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
//    public ModelAndView welcomePage(Model model) {
//        model.addAttribute("title", "Welcome");
//        model.addAttribute("message", "This is welcome page!");
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("/welcome.html");
//        return mv;
//    }
	
	@RequestMapping("/topics")
	public List<Topics> getAllTopics(){
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topics getSpecificTopic(@PathVariable String id) {
		return topicService.getSpecificTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topics topic) {
		topicService.addTopic(topic);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@PathVariable String id, @RequestBody Topics topic) {
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
}
