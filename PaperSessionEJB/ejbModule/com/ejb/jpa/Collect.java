package com.ejb.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CollectPaper")
public class Collect {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int collectID;
	
	private int userID;
	private int paperID;
	
	public int getCollectID() {
		return collectID;
	}
	public void setCollectID(int collectID) {
		this.collectID = collectID;
	}
	public int getUserID() {
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
	
}
