package org.icm.action;





import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.icm.facade.IUserBo;
import org.icm.model.UserMaster;
import org.icm.token.AuthenticationTokenCache;
import org.icm.token.Token;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/**
 * Acts as a controller to handle actions
 * related to registering a user.
 */

public class RegisterAction extends ActionSupport implements ServletRequestAware{
	
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(RegisterAction.class);
	
	private UserMaster userBean, user;
	private Map<String, Object> session;
	private IUserBo userBo;
	private String capchaCode;
	private HttpServletRequest request;
	
	
	@Override
	public String execute() {
		input();
		// Check that username is not existed
		user = userBo.checkUser(userBean.getUserName(),userBean.getEmail());
		logger.info("inside register action"+ user);
		if(user == null){
		int id	= userBo.addUser(userBean);
		logger.info("user inserted id" + id);
			 userBean = userBo.getUser(id);
			 logger.info("user inserted id" + userBean);
				if(userBean!= null){
					session = ActionContext.getContext().getSession();
					session.put("userId", userBean.getUserId());
					session.put("username", userBean.getUserName());
					return SUCCESS;
				}
			 return INPUT;
		}
		else{
			 if(userBean.getUserName().equals(user.getUserName())){
				 addActionError(getText("register.username.exist.error"));
			 }
			 else if(userBean.getEmail().equals(user.getEmail())){
				 addActionError(getText("register.useremail.exist.error"));
			 }
			
			return INPUT;
		}
		
		
	}
	public String input(){
		
		return SUCCESS;
	}
	public void validate(){
		input();
		clearErrorsAndMessages();
		if(userBean != null){
			if(userBean.getUserName() == null || userBean.getUserName().trim().length() == 0)
				 addFieldError("userBean.userName", getText("register.username.error"));
			if(userBean.getPassword() == null || userBean.getPassword().trim().length() == 0)
				addFieldError("userBean.password", getText("register.password.error"));
			if(userBean.getPassword().trim().length() > 1 && userBean.getPassword().trim().length() < 8)
				addFieldError("userBean.password", getText("register.password.length.error"));
			if(userBean.getEmail() == null || userBean.getEmail().trim().length() == 0)
				 addFieldError("userBean.userName", getText("register.email.error"));
			if(getCapchaCode() == null || getCapchaCode().trim().length() == 0)
				addFieldError("capchaCode", getText("register.captcha.error"));
			if(getCapchaCode() != null && getCapchaCode().trim().length() > 0){
				String sessionId = null;
				Token token = null;
				HttpSession s = null;
				// create a session if required
				s = request.getSession(false);
				sessionId = s.getId();
				token = (Token) AuthenticationTokenCache.getInstance().getSessionToken(sessionId);
				if(!token.validateResponse(getCapchaCode())){
					addFieldError("capchaCode", getText("register.captcha.incorrect.error"));
				}
			}
			
		}
		
	}
	public UserMaster getUserBean() {
		return userBean;
	}
	public void setUserBean(UserMaster userBean) {
		this.userBean = userBean;
	}
	public IUserBo getUserBo() {
		return userBo;
	}
	public void setUserBo(IUserBo userBo) {
		this.userBo = userBo;
	}
	public String getCapchaCode() {
		return capchaCode;
	}
	public void setCapchaCode(String capchaCode) {
		this.capchaCode = capchaCode;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
}
