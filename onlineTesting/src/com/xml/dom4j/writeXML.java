package com.xml.dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.sql.*;

import com.bean.*;
import com.database.jdbc.Database;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;

public class writeXML {
	public int doWrite(Paper p,String name){
		int total = 0;
		Document document = DocumentHelper.createDocument(); 
		document.setXMLEncoding("utf-8");
		Element root = document.addElement("paper");  
		List<Question2> question2 = p.getQuestion2s();
		List<Question1> question1 = p.getQuestion1s();
		
		for(Question2 q2 : question2){
			Element e1 = root.addElement("question");
			e1.addAttribute("class","opt");
			e1.addElement("title").addText(q2.getQuestion());
			e1.addElement("item1").addText(q2.getItem1());
			e1.addElement("item2").addText(q2.getItem2());
			e1.addElement("item3").addText(q2.getItem3());
			e1.addElement("item4").addText(q2.getItem4());
			e1.addElement("answer").addText(q2.getAnswer());
			e1.addElement("score").addText(String.valueOf(q2.getScore()));
			total += q2.getScore();
		}
		for(Question1 q1 : question1){
			Element e2 = root.addElement("question");
			e2.addAttribute("class","pra");
			e2.addElement("title").addText(q1.getQuestion());
			e2.addElement("answer").addText(q1.getAnswer());
			e2.addElement("score").addText(String.valueOf(q1.getScore()));
			total += q1.getScore();
		}
		try{
		 FileOutputStream fos = new FileOutputStream("F:\\javaeeData\\"+name+".xml");  
	     OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");  
	     XMLWriter writer = new XMLWriter(osw);  
	     writer.write(document);  
	     writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return total;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("F:\\javaeeData\\大学高等数学.xml");
		Paper paper = new parseXML().parse(file);
		System.out.println(new writeXML().doWrite(paper, "test"));
	}

}
