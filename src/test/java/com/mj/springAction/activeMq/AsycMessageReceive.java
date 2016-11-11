package com.mj.springAction.activeMq;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * 创建消息监听器
 * @author mingjing
 *
 */
@MessageDriven(mappedName="jms/spittle.alert.queue")
public class AsycMessageReceive implements MessageListener{

	@Resource
	private MessageDrivenContext mdc ;
	public void onMessage(Message arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
