package com.xml.dom4j;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import java.sql.*;

import com.bean.*;
import com.database.jdbc.Database;

public class parseXML {
	//Paper paper = new Paper();
	List<Question1> q1s = new ArrayList();
	List<Question2> q2s = new ArrayList();
	/*
	public Paper parse(File file){
		 SAXReader reader = new SAXReader();  
	        //读取文件 转换成Document  
		 try{
	        Document document = reader.read(file);  
	        //获取根节点元素对象  
		 
	        Element root = document.getRootElement();  
	        //遍历  
	        listNodes(root);  
		 }catch(Exception e){
			 e.printStackTrace();
			 System.out.println("读取xml文件出错");
		 }
		return null;
	}*/
	public Paper parse(File file){
		 SAXReader reader = new SAXReader();  
		 Paper paper = new Paper();
		 try{
	        Document document = reader.read(file);  
	        Element root = document.getRootElement();
	        Iterator<Element> iterator = root.elementIterator(); 
	        while(iterator.hasNext()){
	        	Element e = iterator.next();  
	            listNodes(e);  
	        }
	        paper.setQuestion1s(this.q1s);
	        paper.setQuestion2s(this.q2s);
		 }catch(Exception e){
			 e.printStackTrace();
			 System.out.println("读取xml文件出错");
		 }
		return paper;
	}
    public void listNodes(Element node){  
//System.out.println("当前节点的名称：" + node.getName());  
        //首先获取当前节点的所有属性节点  
        List<Attribute> list = node.attributes();  
//System.out.println("attribute"+list.size());
        //遍历属性节点  
        if(list.get(0).getValue().equals("pra")){
        	Question1 q1 = new Question1();
        	List<Element> children = node.elements();
//System.out.println(children.size());
        	q1.setQuestion(children.get(0).getText());
        	q1.setAnswer(children.get(1).getText());
        	q1.setScore(Integer.valueOf(children.get(2).getText()));
        	this.q1s.add(q1);
        }else{
        	Question2 q2 = new Question2();
        	List<Element> children = node.elements();  
//System.out.println(children.size());
        	q2.setQuestion(children.get(0).getText());
        	q2.setItem1(children.get(1).getText());
        	q2.setItem2(children.get(2).getText());
        	q2.setItem3(children.get(3).getText());
        	q2.setItem4(children.get(4).getText());
        	q2.setAnswer(children.get(5).getText());
        	q2.setScore(Integer.valueOf(children.get(6).getText()));
        	this.q2s.add(q2);
        }
    } 
    public File id2path(int id){
    	String path = "";
    	try{
    	Database DB = new Database();
    	Connection conn = DB.getConn();
    	Statement stmt = DB.getStatement(conn);
    	String sql = "select PaperPath from paper where PaperID="+id;
    	ResultSet rs = DB.getResultSetQ(stmt, sql);
    	if(rs.next()){
    		path = rs.getString("PaperPath");
    	}
    	}catch(SQLException e){
    		e.printStackTrace();
    		System.out.println("id2path sql error");
    	}
    	File file = new File("F:\\javaeeData\\"+path);
    	return file;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("F:\\javaeeData\\大学高等数学.xml");
		Paper paper = new parseXML().parse(file);
		for(int i = 0;i<paper.getQuestion1s().size();i++){
			System.out.println(i+"--"+paper.getQuestion1s().get(i).getQuestion());
		}
		for(int i = 0;i<paper.getQuestion2s().size();i++){
			System.out.println(i+"--"+paper.getQuestion2s().get(i).getQuestion());
		}
		//new parseXML().parse(file);
	}

}
