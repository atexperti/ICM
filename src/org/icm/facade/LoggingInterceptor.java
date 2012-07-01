package org.icm.facade;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoggingInterceptor implements Interceptor{

	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(LoggingInterceptor.class);
	
	public String intercept(ActionInvocation invocation) {
		String result = null;
		try {
			String className = invocation.getAction().getClass().getName();
			result = invocation.invoke();
			logger.info(className + " Result is " +  result);
			return result ;
		} catch (Exception e) {
			logger.info(" exception " + result);
			return result ;
		}
	}

	public void destroy() {
		logger.info("Destroying LoggingInterceptor...");
	}

	public void init() {
		logger.info("Initializing LoggingInterceptor...");
	}

}