package com.mj.springAction.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
/**
 * 
 * @author jing.ming
 *
 */
@Component
public class QueueSender {

	private final JmsTemplate jmsTemplate ;
	
	@Autowired
    public QueueSender( final JmsTemplate jmsTemplate )
    {
        this.jmsTemplate = jmsTemplate;
    }
 
	
    public void send( final String message )
    {
        jmsTemplate.convertAndSend( "FirstQueue", message );
    }
}
