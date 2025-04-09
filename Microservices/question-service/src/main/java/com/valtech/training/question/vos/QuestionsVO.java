package com.valtech.training.question.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.question.entities.Questions;

public record QuestionsVO(long id,String text,String op1,String op2,String op3,String ans,String topic) {
	
	public static QuestionsVO from (Questions q) {
		return new QuestionsVO(q.getId(), q.getText(), q.getOp1(), q.getOp2(), q.getOp3(), q.getAns(), q.getTopic());
	}
	
	
	public Questions to() {
		return new Questions(text, op1, op2, op3, ans, topic);
	}

   public static List<QuestionsVO> from (List<Questions> question){
	   return question.stream().map(q->QuestionsVO.from(q)).collect(Collectors.toList());
   }

}


