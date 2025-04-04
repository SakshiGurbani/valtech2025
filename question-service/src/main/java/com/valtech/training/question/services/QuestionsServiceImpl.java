package com.valtech.training.question.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.question.entities.Questions;

import com.valtech.training.question.repos.QuestionsRepo;
import com.valtech.training.question.vos.QuestionsVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionsServiceImpl implements QuestionsService  {
	
	@Autowired
	private QuestionsRepo questionsRepo;
	

	@Override
	public QuestionsVO saveOrUpdateQuestion(QuestionsVO qvo) {
		return QuestionsVO.from(questionsRepo.save(qvo.to()));
	}
	@Override
	public QuestionsVO getQuestion(int id) {
		return QuestionsVO.from(questionsRepo.getReferenceById(id));
	}
	@Override
	public List<QuestionsVO> getQuestions(){
		return QuestionsVO.from(questionsRepo.findAll());
	}
	@Override
	public List<QuestionsVO> getQuestionsFromTopic(String topic){
		return QuestionsVO.from(questionsRepo.findAllByTopic(topic));
	}
	@Override
	public Integer countByTopic(String topic) {
		return questionsRepo.countByTopic(topic);
	}
	@Override
	public List<QuestionsVO> getQuestions(List<Integer> listint) {
		List<Questions> qs = questionsRepo.findAllById(listint);
	
		return qs.stream().map(q -> QuestionsVO.from(q)).collect(Collectors.toList());
	}
	
	
	
	


}
