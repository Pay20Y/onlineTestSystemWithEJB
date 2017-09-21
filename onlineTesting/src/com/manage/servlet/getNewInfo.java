package com.manage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.assistant.AsynReceiveMessage.AsynMesListener;

/**
 * Servlet implementation class getNewInfo
 */
@WebServlet("/getNewInfo")
public class getNewInfo extends HttpServlet {
	public static String info = "";
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private static final String DEFAULT_DESTINATION = "jms/queue/TestTopic";
	private static final String DEFAULT_USERNAME="onlinetest";
	private static final String DEFAULT_PASSWORD="rootadmin";
	private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	private static final String PROVIDER_URL = "http-remoting://localhost:8080";
	
	public static class AsynMesListener implements MessageListener{
		//public String message = "";
		@Override
		public void onMessage(Message msg) {
			// TODO Auto-generated method stub
			TextMessage tm = (TextMessage) msg;
			try{
				info = tm.getText();
				//System.out.println("onMessage,recv text="+tm.getText());
				//message = tm.getText();
			}catch(Throwable t){
				t.printStackTrace();
			}
			
		}
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getNewInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Context context = null;
		Connection connection = null;
		TextMessage msg = null;
		AsynMesListener l = null;
		try{
			final Properties env = new Properties();
			env.put(Context.INITIAL_CONTEXT_FACTORY,INITIAL_CONTEXT_FACTORY );
			env.put(Context.PROVIDER_URL,PROVIDER_URL);
			env.put(Context.SECURITY_PRINCIPAL,DEFAULT_USERNAME);
			env.put(Context.SECURITY_CREDENTIALS, DEFAULT_PASSWORD);
			context = new InitialContext(env);
			ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(DEFAULT_CONNECTION_FACTORY);
			Destination destination = (Destination) context.lookup(DEFAULT_DESTINATION);
			connection = connectionFactory.createConnection(DEFAULT_USERNAME,DEFAULT_PASSWORD);
			Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
			MessageConsumer consumer = session.createConsumer(destination);
			l = new AsynMesListener();
			consumer.setMessageListener(l);
			connection.start();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(info);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
