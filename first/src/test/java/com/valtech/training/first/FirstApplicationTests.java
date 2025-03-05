package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.valtech.training.first.entities.Question;
import com.valtech.training.first.services.QuestionService;

@SpringBootTest
class FirstApplicationTests {

	@Autowired
	private Arithmetic arithmetic;
	
	@Autowired
	private SimpleInterest simpleInterest;
	
	@Autowired
	private QuestionService questionService;
	
	@Test
	void testArithmetic() {
		assertEquals(10, arithmetic.add(4, 6));
		assertEquals(200, simpleInterest.compute(200, 5, 20));
	}
	
	@Test
//	@Rollback()
	void questionService() {
		assertEquals(5, questionService.findAllByTopic("GK").size());
		assertEquals(6, questionService.findAllByTopic("Java").size());
		
		assertEquals(5, questionService.countByTopic("GK"));
		assertEquals(6, questionService.countByTopic("Java"));
		
		assertEquals(2, questionService.countByTopicAndQuestionTextContaining("Java","Exception"));
		assertEquals(3, questionService.countByTopicAndQuestionTextContaining("Java","Interface"));
		assertEquals(3, questionService.countByTopicAndQuestionTextContainingIgnoreCase("Java","interface"));
		assertEquals(3, questionService.findAllByTopic("GK", 0, 3).size());
		assertEquals(2, questionService.findAllByTopic("GK", 1, 3).size());
	}
	
	
	@BeforeEach
	void initData() {
//		System.out.println("Service Class Name"+questionService.getClass().getName());
		long count=questionService.count();
		if(count!=0)return;
		Question q=questionService.saveQuestion
		(new Question("What is the colour of Hair?","Black","Pink","Green","Red","Black","GK"));
//		assertTrue(q.getId()>0);
//		assertEquals(count+1, questionService.count());
		questionService.saveQuestion(new Question("What is the colour of Sun?","Black","Pink","Green","Yellow","Yellow","GK"));
		questionService.saveQuestion
		(new Question("What is the colour of Mars?","Black","Pink","Green","Red","Red","GK"));
		questionService.saveQuestion
		(new Question("What is the colour of Moon?","Black","Pink","White","Yellow","White","GK"));
		questionService.saveQuestion
		(new Question("What is the colour of Juptier?","Black","Pink","Green","Yellow","Yellow","GK"));
		
		
		questionService.saveQuestion
		(new Question("What is the Super class of Exceptions?","Object","Exception","Throwable","Error","Throwable","Java"));
		
		questionService.saveQuestion
		(new Question("Which class is used to create Dynamic Strings?","String","DynamicString","StringBuilder","Builder","StringBuilder","Java"));
		
		
		questionService.saveQuestion
		(new Question("How many methods are there in marker Interface?","None","One","Two","Many","None","Java"));
		

		questionService.saveQuestion
		(new Question("How many methods are there in functional Interface?","None","One","Two","Many","One","Java"));
		

		questionService.saveQuestion
		(new Question("Can an Interface have private methods?","Yes","No","Maybe","No methods can be there in an interface","Yes","Java"));
		
		

		questionService.saveQuestion
		(new Question("Which subclass of Exception is not checekd by the compiler?","Exception","Error","RuntimeException","None","RuntimeException","Java"));
		
		
	}

}
