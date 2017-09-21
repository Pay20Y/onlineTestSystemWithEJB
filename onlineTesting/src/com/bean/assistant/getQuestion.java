package com.bean.assistant;

import com.database.jdbc.*;
import com.xml.dom4j.parseXML;
import com.xml.dom4j.writeXML;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bean.*;

public class getQuestion {
	public Paper generate(String[] opts,String[] pras){
		Paper paper = new Paper();
		List<Question1> ques1 = new ArrayList();
		List<Question2> ques2 = new ArrayList();
		Database DB = new Database();
		Connection conn = DB.getConn();
		Statement stmt = DB.getStatement(conn);
		
		for(String opt : opts){
			int id = Integer.valueOf(opt);
			String sql = "select * from Question2 where QuestionID="+id;
			ResultSet rs = DB.getResultSetQ(stmt, sql);
			try{
			if(rs.next()){
				Question2 q2 = new Question2();
				q2.setQuestion(rs.getString("Question"));
				q2.setItem1(rs.getString("item1"));
				q2.setItem2(rs.getString("item2"));
				q2.setItem3(rs.getString("item3"));
				q2.setItem4(rs.getString("item4"));
				q2.setAnswer(rs.getString("Answer"));
				q2.setScore(rs.getInt("Score"));
				ques2.add(q2);
			}
			rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		for(String pra : pras){
			int id = Integer.valueOf(pra);
			String sql = "select * from Question1 where QuestionID="+id;
			ResultSet rs = DB.getResultSetQ(stmt, sql);
			try{
			if(rs.next()){
				Question1 q1 = new Question1();
				q1.setQuestion(rs.getString("Question"));
				q1.setAnswer(rs.getString("Answer"));
				q1.setScore(rs.getInt("Score"));
				ques1.add(q1);
			}
			rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		paper.setQuestion1s(ques1);
		paper.setQuestion2s(ques2);
		try{
		stmt.close();
		conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return paper;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] opts = {"1","2","3", "4", "5"};
		String[] pras = {"1","2","3", "4", "5"};
		System.out.print(new getQuestion().generate(opts, pras)+"    no error");
	}

}
