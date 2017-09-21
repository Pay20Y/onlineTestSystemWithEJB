package com.manage.servlet;

import java.io.IOException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejb.stateless.deleteQuestion1Remote;
import com.ejb.stateless.deleteQuestion2Remote;

/**
 * Servlet implementation class deleteQuestion
 */
@WebServlet("/deleteQuestion")
public class deleteQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opt = request.getParameter("option");
		int quesid = Integer.valueOf(request.getParameter("opt"));
		try{
		Hashtable<String, String> jndiProperties = new Hashtable<String,String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		String title = null;
		Context context=new InitialContext(jndiProperties);
		final String appName="";
		final String moduleName="QuesSessionEJB";
		final String distinctName="";
		Object object1=context.lookup("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/deleteQuestion1!com.ejb.stateless.deleteQuestion1Remote");
		deleteQuestion1Remote deleteRemote1=(deleteQuestion1Remote)object1;
		Object object2=context.lookup("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/deleteQuestion2!com.ejb.stateless.deleteQuestion2Remote");
		deleteQuestion2Remote deleteRemote2=(deleteQuestion2Remote)object2;
		
		if(opt.equals("1")){
			deleteRemote1.delete(quesid);
		}else if(opt.equals("2")){
			deleteRemote2.delete(quesid);
		}
		
		}catch(NamingException e){
			e.printStackTrace();
			System.out.println("delete ques EJB error");
		}
		RequestDispatcher rd = request.getRequestDispatcher("showQuestionLib.jsp");
        rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
