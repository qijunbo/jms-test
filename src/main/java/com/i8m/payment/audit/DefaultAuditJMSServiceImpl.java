package com.i8m.payment.audit;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class DefaultAuditJMSServiceImpl implements AuditJMSService {

	@Autowired
	public void setConnFactory(ConnectionFactory connFactory) {
		this.jmsTemplate = new JmsTemplate(connFactory);
	}

	@Autowired
	private PropertiesAuditConfig configure;

	private JmsTemplate jmsTemplate;

	@Override
	public void write(final String audit) {

		try {

			if (configure.isAuditEnable()) {

				this.jmsTemplate.send(configure.getQueue(), new MessageCreator() {
					public Message createMessage(Session session) throws JMSException {
						return session.createTextMessage(audit);

					}
				});
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
