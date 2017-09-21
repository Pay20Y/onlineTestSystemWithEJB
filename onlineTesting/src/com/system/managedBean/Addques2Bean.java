package com.system.managedBean;

import java.util.Hashtable;

import javax.faces.bean.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ejb.stateless.addQuestion1Remote;
import com.ejb.stateless.addQuestion2Remote;

@ManagedBean(name="addques2Bean")
@SessionScoped
public class Addques2Bean {
	public Addques2Bean() {
		// TODO Auto-generated constructor stub
	}
	private String questionTitle;
	private String questionAnswer;
	private String item1;
	private String item2;
	private String item3;
	private String item4;
	private int questionScore;
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getQuestionAnswer() {
		return questionAnswer;
	}
	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
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
	public int getQuestionScore() {
		return questionScore;
	}
	public void setQuestionScore(int questionScore) {
		this.questionScore = questionScore;
	}
	
	public String insert() {
		String score = String.valueOf(getQuestionScore());
		String title = getQuestionTitle();
		String answer = getQuestionAnswer();
		String item1 = getItem1();
		String item2 = getItem2();
		String item3 = getItem3();
		String item4 = getItem4();
		
		String question = title+"\t"+item1+"\t"+item2+"\t"+item3+"\t"+item4+"\t"+answer+"\t"+score;
		Hashtable<String, String> jndiProperties = new Hashtable<String,String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		try{
		Context context=new InitialContext(jndiProperties);
		final String appName="";
		final String moduleName="addQuesSessionEJB";
		final String distinctName="";
		Object object=context.lookup("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/addQuestion2!com.ejb.stateless.addQuestion2Remote");
		addQuestion2Remote addRemote=(addQuestion2Remote)object;
		
		addRemote.insert(question);
		//addRemote.sayOK();
		}catch(NamingException e){
			e.printStackTrace();
			System.out.println("添加新的问答题失败");
			return "failure";
		}
//System.out.println("如下:");
//System.out.println(getQuestionTitle());		
		return "success";
	}
	
}
