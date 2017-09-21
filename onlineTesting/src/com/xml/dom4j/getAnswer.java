package com.xml.dom4j;

import com.bean.*;
import java.util.List;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class getAnswer {
	public List<String> getAnswer(Paper paper){
		List<Question1> question1 = new ArrayList<Question1>();
		List<Question2> question2 = new ArrayList<Question2>();
		List<String> answer = new ArrayList<String>();
		question1 = paper.getQuestion1s();
		question2 = paper.getQuestion2s();
		for(int i = 0;i<question2.size();i++){
			answer.add(question2.get(i).getAnswer());
		}
		/*
		for(int i = 0;i<question1.size();i++){
			answer.add(question1.get(i).getAnswer());
		}*/
		return answer;
	}
	
	public List<Integer> getScore(Paper paper){
		List<Question1> question1 = new ArrayList<Question1>();
		List<Question2> question2 = new ArrayList<Question2>();
		List<Integer> score = new ArrayList<Integer>();
		question1 = paper.getQuestion1s();
		question2 = paper.getQuestion2s();
		for(int i = 0;i<question2.size();i++){
			score.add(question2.get(i).getScore());
		}
		for(int i = 0;i<question1.size();i++){
			score.add(question1.get(i).getScore());
		}
		
		return score;
	}
	
	public List<Integer> getScore2(Paper paper){
		List<Question1> question1 = new ArrayList<Question1>();
		//List<Question2> question2 = new ArrayList<Question2>();
		List<Integer> score = new ArrayList<Integer>();
		question1 = paper.getQuestion1s();
		//question2 = paper.getQuestion2s();
		/*
		for(int i = 0;i<question2.size();i++){
			score.add(question2.get(i).getScore());
		}*/
		for(int i = 0;i<question1.size();i++){
			score.add(question1.get(i).getScore());
		}
		
		return score;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Paper paper = new parseXML().parse(new File("F:\\javaeeData\\大学高等数学.xml"));
		//List <String> test = new getAnswer().getAnswer(paper);
		//for(int i = 0;i<test.size();i++){
			//System.out.println(test.get(i));
		//}
		//Date date = new Date();
		//System.out.println(date);
		Date date = new Date();
		String sdate = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
		System.out.println(sdate);
	}

}
