package com.valtech.training.quiz.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.quiz.entities.Quiz;

public record QuizVO(int id,int noOfQuestions,String topic,List<String> answer,List<Integer> questionsId) {
	

	
	
	public static QuizVO from(Quiz quiz) {
		return new QuizVO(quiz.getId(),quiz.getNoOfQuestions(),quiz.getTopic(),quiz.getQuestionsId(),quiz.getAnswer());
	}
	public Quiz to() {
		return new Quiz(noOfQuestions, topic, questionsId);
	}


}



