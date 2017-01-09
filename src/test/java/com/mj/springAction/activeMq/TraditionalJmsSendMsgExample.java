package com.mj.springAction.activeMq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
/**
 * 不使用Spring的传统jms发送消息
 * @author mingjing
 *
 */
public class TraditionalJmsSendMsgExample {

	/**
	 * 发送消息
	 */
	public void sendMessage(){
		ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616") ;
		Connection conn = null ;
		Session see = null ;
		try {
			conn = cf.createConnection() ;
			see = conn.createSession(false, Session.AUTO_ACKNOWLEDGE) ;
			Destination dec = new ActiveMQQueue("FirstQueue") ;
			MessageProducer producer = see.createProducer(dec) ;
			TextMessage message = see.createTextMessage() ;
			message.setText("Hello World!");
			producer.send(message);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
			if(see!=null){
				see.close();
				}
			if(conn !=null){
				conn.close();
				}
			} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		}
			
		}
	/**
	 * 接收消息
	 */
	
	public void reciveMessage(){
		ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616") ;
		Connection conn = null ;
		Session see = null ;
		try {
			conn = cf.createConnection() ;
			conn.start();
			see = conn.createSession(false, Session.AUTO_ACKNOWLEDGE) ;
			Destination dec = new ActiveMQQueue("spitter.queue") ;
			MessageConsumer consumer = see.createConsumer(dec) ;
		    Message message =consumer.receive() ;
			TextMessage textMessage = (TextMessage) message ;
			System.out.println("receive a message:"+textMessage);
			conn.stop();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
			if(see!=null){
				see.close();
				}
			if(conn !=null){
				conn.close();
				}
			} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		}
			
		
	}
		
	}

