package com.valtech.training.resultservice.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

public class Result {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "result_seq")
	@SequenceGenerator(name="result_seq",sequenceName = "result_seq",allocationSize = 1)
	private int id;
	private int quizId;
	private int score;
	
	public Result() {}

	public Result(int id, int quizId, int score) {
		super();
		this.id = id;
		this.quizId = quizId;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
    	
	
	

}
