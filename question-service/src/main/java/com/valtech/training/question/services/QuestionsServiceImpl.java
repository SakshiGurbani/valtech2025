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
	public QuestionsVO saveOrUpdateQuestions(QuestionsVO qvo) {
	  return QuestionsVO.from(questionsRepo.save(qvo.to()));
		
	}
	
	
	
	
	@Override
	public QuestionsVO getQuestionsById(long id) {
		return QuestionsVO.from(questionsRepo.getReferenceById(id));
	}
	
	@Override
	public List<QuestionsVO>getQuestionByTopic(String topic){
		return QuestionsVO.from(questionsRepo.findAllByTopic(topic));
	}
	
	@Override
	public List<QuestionsVO> getAllQuestions(){
		return questionsRepo.findAll().stream().map(qe->QuestionsVO.from(qe)).collect(Collectors.toList());
	}
	
	@Override
	public List<QuestionsVO>getRandomQuestionByTopic(String topic,int number){
		return QuestionsVO.from(questionsRepo.findRandomQuestionsByTopic(topic,number));
	}
	
	@Override
	public List<QuestionsVO>getQuestionsByListOfIds(List<Integer>ids){
		return QuestionsVO.from(questionsRepo.findAllByIds(ids));
	}
	
	
	
	
	
	
	


}
