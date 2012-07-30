package org.icm.action;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.core.io.Resource;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(BaseAction.class);

	private Map<String, Object> session;

	private String userUniuqeId;
	private String activeMenuId;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Collection<Object> languages;
	private boolean languageChanged;

	public boolean isLanguageChanged() {
		return languageChanged;
	}


	public void setLanguageChanged(boolean languageChanged) {
		this.languageChanged = languageChanged;
	}


	public void setLanguages(Collection<Object> languages) {
		this.languages = languages;
	}

	private String language;
	public String getLanguage() {
		if(request.getParameter("lang") != null){
			this.language = request.getParameter("lang");
			setLanguageChanged(true);
			request.getSession().setAttribute("language", this.language);
		}else{
			if(request.getSession().getAttribute("language") != null){
				this.language = (String)request.getSession().getAttribute("language");
			}else{
				this.language = "English";
			}
		}
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}

	
	public Collection<Object> getLanguages() {
		return this.languages;
	}


	public String getActiveMenuId() {
		return activeMenuId;
	}


	public void setActiveMenuId(String activeMenuId) {
		this.activeMenuId = activeMenuId;
	}

	public HttpServletRequest getRequest() {
		return request;
	}


	public HttpServletResponse getResponse() {
		return response;
	}

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


	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}


	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
}
