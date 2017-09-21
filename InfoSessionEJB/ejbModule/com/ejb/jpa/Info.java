package com.ejb.jpa;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="TestInfo")
public class Info {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int infoID;
	
	private String infoTitle;
	private String infoCont;
	private String infoDate;
	
	private int paperID;
	
	public int getInfoID() {
		return infoID;
	}
	public void setInfoID(int infoID) {
		this.infoID = infoID;
	}
	public String getInfoTitle() {
		return infoTitle;
	}
	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}
	public String getInfoCont() {
		return infoCont;
	}
	public void setInfoCont(String infoCont) {
		this.infoCont = infoCont;
	}
	public String getInfoDate() {
		return infoDate;
	}

	public void setInfoDate(String infoDate) {
		this.infoDate = infoDate;
	}
	public int getPaperID() {
		return paperID;
	}
	public void setPaperID(int paperID) {
		this.paperID = paperID;
	}
	
}
