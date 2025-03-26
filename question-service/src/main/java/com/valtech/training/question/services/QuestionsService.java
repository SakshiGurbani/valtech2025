package com.valtech.training.question.services;

import java.util.List;

import com.valtech.training.question.vos.QuestionsVO;

public interface QuestionsService {

	QuestionsVO saveOrUpdateQuestions(QuestionsVO qvo);

	QuestionsVO getQuestionsById(long id);

	List<QuestionsVO> getQuestionByTopic(String topic);

	List<QuestionsVO> getAllQuestions();

	List<QuestionsVO> getRandomQuestionByTopic(String topic, int number);

	List<QuestionsVO> getQuestionsByListOfIds(List<Integer> ids);

}