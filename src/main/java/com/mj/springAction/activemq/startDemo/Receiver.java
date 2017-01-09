package com.mj.springAction.activemq.startDemo;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 
 * @author jing.ming
 *
 */
public class Receiver {

	public static void main(String[] args) {
		ConnectionFactory connectionFactory ;
		Connection connection=null ;
		Session session =null ;
		Destination destination ;
		MessageConsumer consumer ;
		
		connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
		
		try {
			connection = connectionFactory.createConnection() ;
			connection.start();
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE) ;
			destination = session.createQueue("FirstQueue") ;
			consumer = session.createConsumer(destination) ;
			while(true){
				TextMessage message = (TextMessage)consumer.receive(500000) ;
				if(message!=null){
					 System.out.println("收到消息" + message.getText());
				}else {
	                break;
	            }
			}
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            try {
                if (null != connection)
                    connection.close();
            } catch (Throwable ignore) {
            }
		}
	}

}
