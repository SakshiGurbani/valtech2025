package com.valtech.training.quiz.services;

import java.util.List;

import com.valtech.training.quiz.vos.QuestionVO;
import com.valtech.training.quiz.vos.QuizVO;

public interface QuizService {

	QuizVO getQuiz(int id);

	QuizVO createQuiz(QuizVO qivo);

	List<Integer> getRandomQuestionIds(List<QuestionVO> allQuestions, int noOfQuestions);

	List<QuestionVO> getQuesByTopicAndNoOfQue(String topic, int noOfQuestions);

	QuizVO takeQuiz(int quizId, List<String> answers);

	List<String> getAnswers(int id);

	List<QuestionVO> getQuestionsByQuiz(int id);

}