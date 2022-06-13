package com.lgcns.test;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class RunManager {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		Server server = new Server(8080);
//		ContextHandler context = new ContextHandler();
//		context.setContextPath("/CREATE");
//		context.setHandler(new CreateHandler());
//		context.setContextPath("/SHUTDOWN");
//		context.setHandler(new CreateHandler());
//		server.setHandler(context);
//		server.start();
//		server.join();
		Server server = new Server();

		ServerConnector http = new ServerConnector(server);

		http.setHost("127.0.0.1");

		http.setPort(8080);

		server.addConnector(http);

		ServletHandler servletHandler = new ServletHandler();

		servletHandler.addServletWithMapping(CreateServlet.class, "/CREATE/*");
		servletHandler.addServletWithMapping(MyServlet.class, "/*");

		server.setHandler(servletHandler);

		server.start();
		server.join();
	}

}
