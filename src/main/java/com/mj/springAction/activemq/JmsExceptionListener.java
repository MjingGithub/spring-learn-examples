package com.mj.springAction.activemq;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;

import org.springframework.stereotype.Component;
/**
 * 
 * @author jing.ming
 *
 */
@Component
public class JmsExceptionListener implements ExceptionListener{

	public void onException(final JMSException exception) {
		exception.printStackTrace(); 	
	}

}
