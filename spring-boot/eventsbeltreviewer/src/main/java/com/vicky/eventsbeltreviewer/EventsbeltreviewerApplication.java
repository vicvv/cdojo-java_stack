package com.vicky.eventsbeltreviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.apache.catalina.connector.Connector;


import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;


@SpringBootApplication
public class EventsbeltreviewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsbeltreviewerApplication.class, args);
	}
	@Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        Connector ajpConnector = new Connector("AJP/1.3");
        ajpConnector.setPort(9090);
        ajpConnector.setSecure(false);
        ajpConnector.setAllowTrace(false);
        ajpConnector.setScheme("http");
        tomcat.addAdditionalTomcatConnectors(ajpConnector);
        return tomcat;
    }

}
