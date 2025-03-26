package com.valtech.training.quiz.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.quiz.entities.Quiz;

public record QuizVO(long id,long noOfQuestions,String topic,List<String> answer,List<Integer> questionsId) {
	
	public static QuizVO from (Quiz q) {
		return new QuizVO(q.getId(), q.getNoOfQuestions(), q.getTopic(),q.getAnswer(),q.getQuestionsId());
		
	}
	
	public Quiz to() {
		Quiz quiz= new Quiz(noOfQuestions, topic);
		quiz.setAnswer(answer);
		return quiz;
		
		//vo class me se quiz chahiye toh ,,,to call krenge
	}
   
	public static List<QuizVO>from (List<Quiz>quiz){
		return quiz.stream().map(q->QuizVO.from(q)).collect(Collectors.toList());
	}

}




//id,
//quizId
//score