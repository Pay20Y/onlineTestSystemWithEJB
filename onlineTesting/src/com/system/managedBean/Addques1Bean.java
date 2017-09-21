package com.system.managedBean;

import java.io.Serializable;
import java.util.*;

//import javax.enterprise.context.SessionScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.naming.*;

import com.ejb.stateless.addQuestion1Remote;

@ManagedBean(name = "addques1Bean")
@SessionScoped
public class Addques1Bean{
	public Addques1Bean() {
		// TODO Auto-generated constructor stub
	}
	private String questionTitle;
	private String questionAnswer;
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


	public int getQuestionScore() {
		return questionScore;
	}


	public void setQuestionScore(int questionScore) {
		this.questionScore = questionScore;
	}
	
	public String insert() {
		String score = String.valueOf(getQuestionScore());
		//List<String> question = new ArrayList<String>();
		String title = getQuestionTitle();
		String answer = getQuestionAnswer();
		/*
		question.add(title);
		question.add(answer);
		question.add(score);
		*/
		String question = title+"\t"+answer+"\t"+score;
		Hashtable<String, String> jndiProperties = new Hashtable<String,String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		try{
		Context context=new InitialContext(jndiProperties);
		final String appName="";
		final String moduleName="addQuesSessionEJB";
		final String distinctName="";
		Object object=context.lookup("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/addQuestion1!com.ejb.stateless.addQuestion1Remote");
		addQuestion1Remote addRemote=(addQuestion1Remote)object;
		
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
