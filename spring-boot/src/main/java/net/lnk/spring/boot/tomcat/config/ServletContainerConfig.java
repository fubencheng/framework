package net.lnk.spring.boot.tomcat.config;

import java.util.concurrent.TimeUnit;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author Ben
 * @memo 2017年3月3日
 */
@Component
@Configurable
public class ServletContainerConfig {

	@Bean
	public TomcatEmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint constraint = new SecurityConstraint();
				constraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				constraint.addCollection(collection);
				context.addConstraint(constraint);
			}
		};
		factory.setSessionTimeout(30, TimeUnit.MINUTES);
		factory.addAdditionalTomcatConnectors(httpConnector());
		return factory;
	}

	@Bean
	public Connector httpConnector() {
		Connector connector = new Connector(Http11NioProtocol.class.getName());
		connector.setScheme("http");
		connector.setPort(8080);
		connector.setSecure(Boolean.FALSE);
		connector.setRedirectPort(8443);

		Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
		// 设置最大连接数
		protocol.setMaxConnections(1000);
		// 设置最大线程数
		protocol.setMaxThreads(1000);
		protocol.setConnectionTimeout(30000);

		return connector;
	}

}
