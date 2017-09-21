package com.ejb.jpa;

import javax.persistence.*;

@Entity
@Table(name="Paper")
public class Paper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paperID;
	
	private String paperName;
	private String paperPath;
	private int totalScore;
	public int getPaperID() {
		return paperID;
	}
	public void setPaperID(int paperID) {
		this.paperID = paperID;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public String getPaperPath() {
		return paperPath;
	}
	public void setPaperPath(String paperPath) {
		this.paperPath = paperPath;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	
	
}
