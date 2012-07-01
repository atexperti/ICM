package org.icm.action;

import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(BaseAction.class);

	private Map<String, Object> session;

	private String userUniuqeId;


	public static final String FAILURE = "failure";

	private Resource configLocation;

	public void init() {

		try {
			
		} catch (Exception e) {
			logger.error(e);
		}

	}
	

	public void setConfigLocation(Resource configLocation) {

		this.configLocation = configLocation;
	}

	public Resource getConfigLocation() {
		return configLocation;
	}

	
	/**
	 * @return the userUniuqeId
	 */
	public String getUserUniuqeId() {
		this.userUniuqeId = UUID.randomUUID().toString();
		return this.userUniuqeId;
	}

	/**
	 * @return the session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
