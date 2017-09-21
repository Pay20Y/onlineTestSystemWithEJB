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

import com.bean.*;
import com.bean.assistant.getQuestion;
import com.ejb.stateless.addPaperRemote;
import com.xml.dom4j.writeXML;

/**
 * Servlet implementation class addPaper
 */
@WebServlet("/addPaper")
public class addPaper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPaper() {
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
		boolean addOK = true;
		
		String papername = request.getParameter("paperName");
		int optnum = Integer.valueOf(request.getParameter("optnum"));
		int nonoptnum = Integer.valueOf(request.getParameter("nonoptnum"));
		String[] opts = request.getParameterValues("opt");
		String[] nonopts = request.getParameterValues("nonopt");
		
		Paper paper = new Paper();
		getQuestion gq = new getQuestion();
		paper = gq.generate(opts, nonopts);
		
		writeXML w = new writeXML();
		int score = w.doWrite(paper, papername);
		try{
		Hashtable<String, String> jndiProperties = new Hashtable<String,String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		Context context=new InitialContext(jndiProperties);
		final String appName="";
		final String moduleName="PaperSessionEJB";
		final String distinctName="";
		Object object=context.lookup("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/addPaper!com.ejb.stateless.addPaperRemote");
		addPaperRemote paperRemote=(addPaperRemote)object;
		paperRemote.insert(papername, papername+".xml", score);
		}catch(NamingException e){
			e.printStackTrace();
			System.out.println("寻找EJB出错");
			addOK = false;
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(addOK){
		out.write("添加成功");
		}else{
		out.write("添加失败");
		}
		out.write("点击<a href='addPaper.jsp'>此处</a>继续添加  <br/>");
		out.write("点击<a href='index.jsp'>此处</a>回到首页 ");
		out.flush();
		out.close();
	}

}
