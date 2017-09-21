package com.ejb.jpa;

import javax.persistence.*;

@Entity
@Table(name="Question1")
public class Question1 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionID;
	
	private String question;
	private String answer;
	private int score;
	
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
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