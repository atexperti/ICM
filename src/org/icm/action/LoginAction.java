package org.icm.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.icm.facade.IUserBo;
import org.icm.model.UserMaster;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport  {
	
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(LoginAction.class);
	private String userName;
	private String password;
	private UserMaster user;
	private int loginAttempts;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	@Autowired
	private IUserBo userBo;
	
	/**
	 * Populate all categories related to device model on index page
	 */
	public String input(){
		
		return SUCCESS;
	}
	/**
	 * Used to login the user and creates new session
	 * @return
	 * @throws Exception
	 */
	public String doLogin() throws Exception {
		
		if(!session.containsKey("loginAttempts")){
			session.put("loginAttempts", loginAttempts + 1);
		}
		System.out.println("userName: "+ userName +": password: "+password);
		user = userBo.getUser(userName, password);
		
		if(user!= null){
			session.remove("loginAttempts");
			session.remove("forgetpassword");
			session.put("userId", user.getUserId());
			session.put("username", user.getUserName());
			return SUCCESS;
		}
		else{
			loginAttempts =	(Integer)session.get("loginAttempts");
			session.put("loginAttempts", loginAttempts+1);
			addActionError(getText("login.faild.error"));
			return INPUT;
		}
	}
	public String doLogout()throws Exception{
		System.out.println("calling do logout");
		session.clear();
		return SUCCESS;
	}
	public void validate(){
		input();
		clearErrorsAndMessages();
		if(getUserName() == null || getUserName().trim().length() == 0)
			 addFieldError("userName", getText("register.username.error"));
		else if(getPassword() == null || getPassword().trim().length() == 0)
			addFieldError("password", getText("register.password.error"));
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserMaster getUser() {
		return user;
	}
	public void setUser(UserMaster user) {
		logger.info("set user bean calling");
		this.user = user;
	}
	
}
