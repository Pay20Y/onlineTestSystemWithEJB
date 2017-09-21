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

import com.ejb.stateless.deleteInfoRemote;

/**
 * Servlet implementation class deleteInfo
 */
@WebServlet("/deleteInfo")
public class deleteInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(request.getParameter("id"));
		try{
		Hashtable<String, String> jndiProperties = new Hashtable<String,String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		String title = null;
		Context context=new InitialContext(jndiProperties);
		final String appName="";
		final String moduleName="InfoSessionEJB";
		final String distinctName="";
		Object object=context.lookup("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/deleteInfo!com.ejb.stateless.deleteInfoRemote");
		deleteInfoRemote deleteRemote=(deleteInfoRemote)object;
		deleteRemote.delete(id);
		}catch(NamingException e){
			e.printStackTrace();
			System.out.println("²éÕÕEJB³ö´í");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
