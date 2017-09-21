package com.manage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejb.stateless.deleteJudgedRemote;
import com.ejb.stateless.getGradeRemote;
import com.ejb.stateless.updateTestRemote;

/**
 * Servlet implementation class getJudged
 */
@WebServlet("/getJudged")
public class getJudged extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getJudged() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num_temp = request.getParameter("num");
		int num = Integer.valueOf(num_temp);
		try{
		Hashtable<String, String> jndiProperties = new Hashtable<String,String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		String title = null;
		Context context=new InitialContext(jndiProperties);
		final String appName="";
		final String moduleName="JudgedSessionEJB";
		final String moduleName2="TestSessionEJB";
		final String distinctName="";
		Object object1=context.lookup("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/deleteJudged!com.ejb.stateless.deleteJudgedRemote");
		Object object2=context.lookup("ejb:"+appName+"/"+moduleName2+"/"+distinctName+"/updateTest!com.ejb.stateless.updateTestRemote");
		Object object3= context.lookup("ejb:"+appName+"/"+moduleName2+"/"+distinctName+"/getGrade!com.ejb.stateless.getGradeRemote");
		deleteJudgedRemote delete = (deleteJudgedRemote)object1;
		updateTestRemote update = (updateTestRemote)object2;
		getGradeRemote get = (getGradeRemote)object3;
		for(int i = 0;i<num;i++){
			String judgedID_temp = request.getParameter("jid"+i);
			String testID_temp = request.getParameter("tid"+i);
			String score_temp = request.getParameter("judge"+i);
			System.out.println(score_temp);
			int score = Integer.valueOf(score_temp);
			int judgedID = Integer.valueOf(judgedID_temp);
			int testID = Integer.valueOf(testID_temp);
			
			int grade = get.getGrade(testID);
			delete.delete(judgedID);
			update.update(testID, grade+score, 1);
		}
		
		}catch(NamingException e){
			e.printStackTrace();
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("批阅成功！");
		out.write("点击<a href='index.jsp'>此处</a>回到首页");
		out.flush();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

}
