package com.cb.listners;

import java.io.InputStream;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class HttpSessionListners
 *
 */
@WebListener
public class HttpSessionListners implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
	System.out.println("HttpSessionListners.sessionCreated()");	
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("HttpSessionListners.sessionDestroyed()");
	}
}
