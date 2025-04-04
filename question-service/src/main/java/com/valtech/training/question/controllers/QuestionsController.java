package com.valtech.training.question.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.valtech.training.question.services.QuestionsService;
import com.valtech.training.question.vos.QuestionsVO;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionsController {
	
	@Autowired
	private QuestionsService questionsService;
	
	@PostMapping("/")
	public QuestionsVO createQuestion(@RequestBody QuestionsVO questionVO) {
		return questionsService.saveOrUpdateQuestion(questionVO);
	}
	
	@GetMapping("/{id}")
	public QuestionsVO getQuestion(@PathVariable("id") int id) {
		return questionsService.getQuestion(id);
	}
	
	@GetMapping("/")
	public List<QuestionsVO> getAllQuestions(){
		return questionsService.getQuestions();
	}
	
	@GetMapping("/topic/{topic}")
	public List<QuestionsVO> getAllQuestionsByTopic(@PathVariable("topic") String topic){
		return questionsService.getQuestionsFromTopic(topic);
	}
	@GetMapping("/questions/{ids}")
	public List<QuestionsVO> getQuestionsOfQuiz(@PathVariable("ids") String ids){
		System.out.println("Inside Question controller............");
		List<Integer> listint = Arrays.stream(ids.split(",")).map(Integer::parseInt)
				.collect(Collectors.toList());
		
		return questionsService.getQuestions(listint);
	}

}
