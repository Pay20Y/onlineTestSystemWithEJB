package com.ejb.jpa;

import javax.persistence.*;

@Entity
@Table(name="Test")
public class Test {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testID;
	
	private int userID;
	private int paperID;
	private int score;
	private int judged;
	
	public int getTestID() {
		return testID;
	}
	public void setTestID(int testID) {
		this.testID = testID;
	}
	public int getUseID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getPaperID() {
		return paperID;
	}
	public void setPaperID(int paperID) {
		this.paperID = paperID;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getJudged() {
		return judged;
	}
	public void setJudged(int judged) {
		this.judged = judged;
	}
	
}
