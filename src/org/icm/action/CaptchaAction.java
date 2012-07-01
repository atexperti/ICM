package org.icm.action;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.icm.token.AuthenticationTokenCache;
import org.icm.token.Token;
import org.icm.token.TokenInstantiationException;
import org.icm.token.factory.TokenFactory;

import com.opensymphony.xwork2.ActionSupport;

public class CaptchaAction extends ActionSupport implements ServletRequestAware{

	
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(CaptchaAction.class);
	private HttpServletRequest request;
	private TokenFactory factory ;
	private ByteArrayInputStream inputStream;
	private ByteArrayOutputStream outputStream;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public String execute()  {
		String sessionId = null;
		Token token = null;
		HttpSession s = null;
		try {
			factory = TokenFactory.getInstance("org.icm.token.factory.SimpleTokenFactory");
		} 
		catch (TokenInstantiationException tie) {
			try {
				throw new UnavailableException("Unable to retrieve the configured token factory"+tie.getMessage());
			} catch (UnavailableException e) {
				logger.error(e);
			}
		}
		//create a session if required
        s = request.getSession(true);
		sessionId = s.getId();
		if (token == null) {
			token = factory.getToken();
			AuthenticationTokenCache.getInstance().addSessionToken(sessionId,token);
		}
		outputStream = new ByteArrayOutputStream() ;
        try {
			ImageIO.write(token.getTokenImage(), "png", outputStream);
		} catch (IOException e) {
			logger.error(e);
		}
		inputStream = new ByteArrayInputStream(outputStream.toByteArray());
       
		return SUCCESS;
		
	}
	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}
	
	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public ByteArrayOutputStream getOutputStream() {
		return outputStream;
	}
	public void setOutputStream(ByteArrayOutputStream outputStream) {
		this.outputStream = outputStream;
	}
	

}
