package com.lgcns.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CreateHandler extends AbstractHandler {
	Gson gson = new Gson();
	
	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("contextPath:"+request.getContextPath());
		System.out.println("queryString:"+request.getQueryString());
		System.out.println("URI:"+request.getRequestURI());
//		System.out.println(request.getReader().readLine());
		String line;
		String all = "";
		while(( line = request.getReader().readLine()) != null) {
			all += line;
		}
//		CreateData d = gson.fromJson(all, CreateData.class);
//		
//		System.out.println(d.QueueSize);
		
		String[] uri = request.getRequestURI().split("/");
		String name = uri[1];

		response.setContentType("text/html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        try {
			response.getWriter().write(gson.toJson(MyService.getInstace().create(name, 0)));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        baseRequest.setHandled(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


