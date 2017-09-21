package com.bean.assistant;
import javax.naming.*;
import javax.jms.*;
import java.util.Properties;


public class JMSUtil {
	final static String JMS_CONNECTION_FACTORY_JNDI = "jms/RemoteConnectionFactory";
    final static String JMS_TOPIC_JNDI = "jms/queue/TestTopic";
    final static String JMS_USERNAME = "onlinetest";
    final static String JMS_PASSWORD = "rootadmin";
    private final static String WILDFLY_REMOTING_URL = "http-remoting://localhost:8080";//注意前缀格式和端口，不是4447
    //private final static String WILDFLY_REMOTING_URL = "remote://localhost:8080";//注意前缀格式和端口，不是4447哦
 
    static InitialContext getInitialContext() throws NamingException {
        InitialContext context = null;
        try {
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            props.put(Context.PROVIDER_URL, WILDFLY_REMOTING_URL);// NOTICE: "http-remoting" and port "8080"
            props.put(Context.SECURITY_PRINCIPAL, JMS_USERNAME);
            props.put(Context.SECURITY_CREDENTIALS, JMS_PASSWORD);
            //props.put("jboss.naming.client.ejb.context", true);
            context = new InitialContext(props);
            System.out.println("\n\tGot initial Context: " + context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return context;
    }
}
