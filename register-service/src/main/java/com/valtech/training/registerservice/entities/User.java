package com.valtech.training.registerservice.entities;

import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "user_seq")
	@SequenceGenerator(name="user_seq",sequenceName = "user_seq",allocationSize = 1)
	private long id;
	private String name;
	private int age;
	private String mobileNo;
	private String email;
	private boolean isKid;
	
	@ManyToOne(targetEntity = Subscription.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="subscription_id",referencedColumnName = "id")
	private Subscription subscription;
	
	
	public User() {}

	public User(String name, int age, String mobileNo, String email) {
		this.name = name;
		this.age = age;
		this.mobileNo = mobileNo;
		this.email = email;
	}

	public User(String name, int age, String mobileNo, String email, boolean isKid) {
		this.name = name;
		this.age = age;
		this.mobileNo = mobileNo;
		this.email = email;
		this.isKid = isKid;
	}

	public User(String name, int age, String mobileNo, String email, boolean isKid, Subscription subscription) {
		this.name = name;
		this.age = age;
		this.mobileNo = mobileNo;
		this.email = email;
		this.isKid = isKid;
		this.subscription = subscription;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	
	public Subscription getSubscription() {
		return subscription;
	}

	public boolean isKid() {
		return isKid;
	}

	public void setKid(boolean isKid) {
		this.isKid = isKid;
	}



	
	
	
	
	
	
	
	
	
	
	
	

}
