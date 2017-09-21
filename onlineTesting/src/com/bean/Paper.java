package com.bean;

import java.util.ArrayList;
import java.util.List;

public class Paper {
	private List<Question1> question1s = new ArrayList<Question1>();
	private List<Question2> question2s = new ArrayList<Question2>();
	
	public List<Question1> getQuestion1s() {
		return question1s;
	}
	public void setQuestion1s(List<Question1> question1s) {
		this.question1s = question1s;
	}
	public List<Question2> getQuestion2s() {
		return question2s;
	}
	public void setQuestion2s(List<Question2> question2s) {
		this.question2s = question2s;
	}
	
	
}
