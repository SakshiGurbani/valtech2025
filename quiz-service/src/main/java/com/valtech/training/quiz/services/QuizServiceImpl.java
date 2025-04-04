package com.valtech.training.quiz.services;

import java.util.Collections;
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
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	private QuestionClient questionClient;

	
	@Override
	public QuizVO getQuiz(int id) {
		Quiz quiz = quizRepo.getReferenceById(id);
		return QuizVO.from(quizRepo.getReferenceById(id));
	}
	
	


	@Override
	public QuizVO createQuiz(QuizVO qivo) { 
		Quiz quiz = qivo.to();
		String topic = quiz.getTopic();
		
		int noOfQuestions = quiz.getNoOfQuestions();
		List<QuestionVO> allQuestions = questionClient.getQuestionsByTopicFromQuestion(topic);
		
		List<Integer> questionIds = getRandomQuestionIds(allQuestions,noOfQuestions);
		quiz.setTopic(topic);
		quiz.setNoOfQuestions(noOfQuestions);
		quiz.setQuestionsId(questionIds);
		quiz.setAnswer(qivo.answer());
		
		quiz = quizRepo.save(quiz);
		return QuizVO.from(quiz);
	}


	@Override
	public List<Integer> getRandomQuestionIds(List<QuestionVO> allQuestions, int noOfQuestions) {
	
		Collections.shuffle(allQuestions);
		return allQuestions.stream().limit(noOfQuestions).map(QuestionVO::id).collect(Collectors.toList());
	}
	
	@Override
	public List<QuestionVO> getQuesByTopicAndNoOfQue(String topic, int noOfQuestions){
		List<QuestionVO> allQuestions = questionClient.getQuestionsByTopicFromQuestion(topic);
		Collections.shuffle(allQuestions);
		return allQuestions.stream().limit(noOfQuestions).collect(Collectors.toList());
	} 
	
	@Override
	public QuizVO takeQuiz(int quizId,List<String> answers) {
		Quiz quiz = quizRepo.getReferenceById(quizId);
		quiz.setAnswer(answers);
		quiz = quizRepo.save(quiz);
		return QuizVO.from(quiz);		
	}
	
	@Override
	public List<String> getAnswers (int id){
		Quiz quiz = quizRepo.getReferenceById(id);
		return quiz.getAnswer();
	}
	
	@Override
	public List<QuestionVO> getQuestionsByQuiz(int id){
		Quiz quiz = quizRepo.getReferenceById(id);
		return questionClient.getQuestionsByIds(quiz.getQuestionsId());
	}
	
}
