package com.i8m.payment.audit;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ibm.mq.jms.MQXAConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;

@Configuration
public class PropertiesAuditConfig {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Value("${mq.host}")
	String host;

	@Value("${mq.port}")
	int port;

	@Value("${mq.qManager}")
	String qManager;

	@Value("${mq.channel}")
	String channel;

	@Value("${mq.queue}")
	String queue;

	@Value("${auditEnable}")
	boolean auditEnable;

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public String getqManager() {
		return qManager;
	}

	public String getChannel() {
		return channel;
	}

	public String getQueue() {
		return queue;
	}

	public boolean isAuditEnable() {
		return auditEnable;
	}

	@Bean
	public ConnectionFactory messageGatewayJmsConnectionFactory() {
		MQXAConnectionFactory connectionFactory = new MQXAConnectionFactory();
		try {
			connectionFactory.setHostName(getHost());
			connectionFactory.setPort(getPort());
			connectionFactory.setQueueManager(getqManager());
			connectionFactory.setChannel(getChannel());
			connectionFactory.setTransportType(WMQConstants.WMQ_CM_CLIENT);
		} catch (JMSException e) {
			LOG.error("can not create MQ connector factory");
			throw new RuntimeException(e);
		}

		LOG.debug("create message connector [qm={}, host={}, port={}, channel={}]", getqManager(), getHost(),
				getPort(), getChannel());

		return connectionFactory;
	}

}
