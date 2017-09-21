package com.ejb.jpa;

import javax.persistence.*;

@Entity
@Table(name="Question2")
public class Question2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionID;
	
	private String question;
	@Column(name="item1")
	private String item1;
	@Column(name="item2")
	private String item2;
	@Column(name="item3")
	private String item3;
	@Column(name="item4")
	private String item4;
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
	public String getItem1() {
		return item1;
	}
	public void setItem1(String item1) {
		this.item1 = item1;
	}
	public String getItem2() {
		return item2;
	}
	public void setItem2(String item2) {
		this.item2 = item2;
	}
	public String getItem3() {
		return item3;
	}
	public void setItem3(String item3) {
		this.item3 = item3;
	}
	public String getItem4() {
		return item4;
	}
	public void setItem4(String item4) {
		this.item4 = item4;
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