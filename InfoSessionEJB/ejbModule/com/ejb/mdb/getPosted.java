package com.ejb.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.ejb.stateless.*;

/**
 * Message-Driven Bean implementation class for: getPosted
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/TestTopic"), 
				@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"), 
				@ActivationConfigProperty(propertyName = "subscriptionDurability",propertyValue = "Durable"),
				@ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "testTopic"), 
				@ActivationConfigProperty(propertyName = "clientID",propertyValue = "consumer"),
		}, 
		mappedName = "queue/TestTopic")
public class getPosted implements MessageListener {
	private MessageDrivenContext mdc;
	private String newMessage;
    /**
     * Default constructor. 
     */
    public getPosted() {
        // TODO Auto-generated constructor stub
    }
	
	public String getNewMessage() {
		return newMessage;
	}

	public void setNewMessage(String newMessage) {
		this.newMessage = newMessage;
	}

	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
        TextMessage msg = null;
        try{
        	if(message instanceof TextMessage){
        		msg = (TextMessage) message;
        		setNewMessage(msg.getText());
        		System.out.println("MDB得到的消息是:"+msg.getText());
        	}else{
        		System.out.println("消息类型不正确");
        	}
        }catch(JMSException e){
        	e.printStackTrace();
        	mdc.setRollbackOnly();
        }
    }

}
