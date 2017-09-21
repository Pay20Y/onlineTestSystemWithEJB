package com.ejb.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Judged")
public class Judged {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int judgedID;
	
	private int testID;
	private String title;
	private String answer;
	private int score;
	
	public int getJudgedID() {
		return judgedID;
	}
	public void setJudgedID(int judgedID) {
		this.judgedID = judgedID;
	}
	public int getTestID() {
		return testID;
	}
	public void setTestID(int testID) {
		this.testID = testID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
