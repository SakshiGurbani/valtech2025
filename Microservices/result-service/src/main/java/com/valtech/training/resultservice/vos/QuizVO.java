package com.valtech.training.resultservice.vos;

import java.util.List;

public record QuizVO(int id,int noOfQuestions, String topic, List<Integer> quiestionIds, List<String> answers) {

}
