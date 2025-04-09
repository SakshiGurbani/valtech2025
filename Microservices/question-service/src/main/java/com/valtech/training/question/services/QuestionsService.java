package com.valtech.training.question.services;

import java.util.List;

import com.valtech.training.question.vos.QuestionsVO;

public interface QuestionsService {

	QuestionsVO saveOrUpdateQuestion(QuestionsVO qvo);

	QuestionsVO getQuestion(int id);

	List<QuestionsVO> getQuestions();

	List<QuestionsVO> getQuestionsFromTopic(String topic);

	Integer countByTopic(String string);

	List<QuestionsVO> getQuestions(List<Integer> listint);

}