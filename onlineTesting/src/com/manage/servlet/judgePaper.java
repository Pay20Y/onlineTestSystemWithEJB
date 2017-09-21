package com.manage.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.*;
import com.ejb.stateless.*;
import com.xml.dom4j.*;
import com.bean.assistant.*;
/**
 * Servlet implementation class judgePaper
 */
@WebServlet("/judgePaper")
public class judgePaper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public judgePaper() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int num1 = Integer.valueOf(request.getParameter("num1"));//ѡ��������
		int num2 = Integer.valueOf(request.getParameter("num2"));//�ʴ�������
		String testid_temp = request.getParameter("testID");
		int testid = Integer.valueOf(testid_temp);
		String paperid_temp = request.getParameter("paperID");
		int paperid = Integer.valueOf(paperid_temp);
		List<String> radio = new ArrayList<String>();
		List<String> answer = new ArrayList<String>();
		List<String> title = new ArrayList<String>();
		for(int i = 0;i<num1;i++){
			radio.add(request.getParameter("radio"+i));
		}
		for(int j = 0;j<num2;j++){
			answer.add(request.getParameter("answer"+j));
		}
		for(int w = 0;w<num2;w++){
			title.add(request.getParameter("title"+w));
		}
System.out.println("¼�����");
System.out.println("ѡ����𰸹�"+radio.size());
		for(int i = 0;i<num1;i++){
			System.out.println(radio.get(i));
		}
System.out.println("�ʴ���𰸹�"+answer.size());
System.out.println("�ʴ���𰸣�"+answer.get(0));
		
		int grade = 0;//�ܷ�
		List<String> youranswer = new ArrayList<String>();
		
		youranswer.addAll(radio);
		//youranswer.addAll(answer);
		
		parseXML px = new parseXML();
		getAnswer ga = new getAnswer();
		
		File file = px.id2path(paperid);
		Paper paper = px.parse(file);
		List <String> rightAnswer = ga.getAnswer(paper);
		List <Integer> score = ga.getScore(paper);
		List <Integer> score2 = ga.getScore2(paper);
		for(int w = 0;w<rightAnswer.size();w++){
			if(youranswer.get(w).equals(rightAnswer.get(w))){
				grade += score.get(w);
			}
		}
		
System.out.println("�ɼ�"+grade);
System.out.println("��ʼ¼�����ݿ�...");
		Hashtable<String, String> jndiProperties = new Hashtable<String,String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		Context context;
		try{
			context = new InitialContext(jndiProperties);
			final String appName="";
			final String moduleName="TestSessionEJB";
			final String moduleName2="JudgedSessionEJB";
			final String distinctName="";
			Object object=context.lookup("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/updateTest!com.ejb.stateless.updateTestRemote");
			updateTestRemote updateRemote=(updateTestRemote)object;
			updateRemote.update(testid,grade,0);
			
			Object object2 = context.lookup("ejb:"+appName+"/"+moduleName2+"/"+distinctName+"/insertJudged!com.ejb.stateless.insertJudgedRemote");
			insertJudgedRemote insert = (insertJudgedRemote)object2;
			for(int i=0;i<answer.size();i++){
				insert.insert(testid, title.get(i), answer.get(i), score2.get(i));
			}
		}catch(NamingException e){
			e.printStackTrace();
			System.out.println("����EJB����");
		}
		
System.out.println("�������ݿ�ɹ�!");
	/*
		List<String> rank = new ArrayList();
		gradeSort gs = new gradeSort();
		rank = gs.execute(paperid);
		*/
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		/*
		out.write("��ϲ����ĳɼ�Ϊ:"+grade+"<br/><br/>");
		out.flush();
		out.write("���Ծ�Ŀǰ��������:<br/>");
		out.write("<table><tr><td>����</td><td>�ɼ�</td></tr><table>");
		for(int i = 0;i<rank.size();i++){
			String[] b = rank.get(i).split("\t");
		out.write("<tr><td>"+b[0]+"</td><td>"+b[1]+"</td></tr>");
		out.flush();
		}
		*/
		out.write("�ύ�ɹ����ȴ���ʦ����");
		out.flush();
		out.close();
	}

}
