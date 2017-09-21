package com.bean.assistant;

import javax.naming.*;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.jms.*;

public class JMSSender {
	public  static int sendTextMessage(String... message) {
        int count = 0;
        InitialContext context = null;
        Connection connection = null;
        try {
            context = JMSUtil.getInitialContext();
            ConnectionFactory factory = (ConnectionFactory) context.lookup(JMSUtil.JMS_CONNECTION_FACTORY_JNDI);
            connection = factory.createConnection(JMSUtil.JMS_USERNAME, JMSUtil.JMS_PASSWORD);
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = (Destination) context.lookup(JMSUtil.JMS_TOPIC_JNDI);
 
            //6. 使用会话和目的地创建消息生产者
            MessageProducer producer = session.createProducer(destination);
            //连接开始
            connection.start();
 
            TextMessage textMessage;
            //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE);
            for (String msg : message) {
                //7. 使用会话创建消息
                textMessage = session.createTextMessage(msg);
               // textMessage.setStringProperty("time", sdf.format(new Date()));
                //8. 发送消息
                producer.send(textMessage);
                count++;
            }
            System.out.println("已发送" + count + "条消息");
        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
            if (context != null) {
                try {
                    context.close();
                } catch (NamingException e) {
                    e.printStackTrace();
                }
            }
 
        }
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        JMSSender.sendTextMessage("hello");
	        JMSSender.sendTextMessage("quit");
	}

}
