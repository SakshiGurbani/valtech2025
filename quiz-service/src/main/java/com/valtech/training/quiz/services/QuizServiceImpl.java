package com.valtech.training.quiz.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.quiz.entities.Quiz;
import com.valtech.training.quiz.repos.QuizRepo;
import com.valtech.training.quiz.vos.QuestionVO;
import com.valtech.training.quiz.vos.QuizVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuizServiceImpl {
	
	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	private QuestionClient questionClient;
	
	public QuizVO saveOrUpdateQuiz(QuizVO qvo) {
		Quiz quiz =qvo.to();
		String topic=quiz.getTopic();
		int number=quiz.getNoOfQuestons();
		List<QuestionVO> randomQuestions=questionClient.getAllQuestionByTopic(topic,number);
		List<Integer> ids=randomQuestions.stream().map(q->q.id()).collect(Collectors.toList());
		
		quiz.setTopic(topic);
		quiz.setNoOfQuestions(number);
		quiz.setQuestionsId(ids);
		quiz.setAnswer(qvo.answer());
		
		return QuizVO.from(quizRepo.save(quiz));
	}
	
	@Override
	public List<QuestionVO> getQuestionsByTopicAndNumberOfQuestions(String topic,int numOfQuestions){
		List<QuestionVO> allQuestions=questionClient.getQuestionsByTopicFromQuestions(topic)
		
		
		
	}
	
	@Override
	public QuizVO getQuiz(long id) {
		Quiz q= quizRepo.getReferenceById(id);
		return QuizVO.from(q);
	}
	
	@Override
	public List<QuizVO> getAllQuiz(){
		return quizRepo.findAll().stream().map(qu->QuizVO.from(qu)).collect(Collectors.toList());
		
	}
	
	@Override
	public QuizVO saveQuiz(QuizVO qvo) {
		Quiz q=qvo.to();
		q=quizRepo.save(q);
		return QuizVO.from(q);
	}
	
	@Override
	public QuizVO updateQuiz(long id,QuizVO qvo) {
		Quiz q= quizRepo.getReferenceById(id);
		qvo.update(q);
		q=quizRepo.save(q);
		return QuizVO.from(q);
		
	}

}
