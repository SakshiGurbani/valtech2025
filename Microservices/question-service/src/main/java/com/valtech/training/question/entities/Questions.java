package com.valtech.training.question.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Questions {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="que_seq")
	@SequenceGenerator(name="que_seq",sequenceName = "que_seq",allocationSize = 1)
	private long id;
	private String text;
	private String op1;
	private String op2;
	private String op3;
	private String ans;
	private String topic;
	
	public Questions() {}

	public Questions(String text, String op1, String op2, String op3, String ans, String topic) {
		this.text = text;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.ans = ans;
		this.topic = topic;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getOp1() {
		return op1;
	}

	public void setOp1(String op1) {
		this.op1 = op1;
	}

	public String getOp2() {
		return op2;
	}

	public void setOp2(String op2) {
		this.op2 = op2;
	}

	public String getOp3() {
		return op3;
	}

	public void setOp3(String op3) {
		this.op3 = op3;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	
	
	

}
