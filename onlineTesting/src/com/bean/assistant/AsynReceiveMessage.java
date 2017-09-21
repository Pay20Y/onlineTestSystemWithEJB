package com.bean.assistant;

import java.io.File;
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

public class AsynReceiveMessage {
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
				System.out.println("onMessage,recv text="+tm.getText());
				//message = tm.getText();
			}catch(Throwable t){
				t.printStackTrace();
			}
			
		}
	}
	public String execute(){
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
		
		
		
		return "ÎÞÏûÏ¢";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(new AsynReceiveMessage().execute());
	}

}
