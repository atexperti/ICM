package org.icm.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.icm.facade.IUserBo;
import org.icm.mail.MailDispature;
import org.icm.model.UserMaster;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ForgetPasswordAction extends ActionSupport {
	/**
	 * 
	 */
	private static Logger logger = Logger.getLogger(ForgetPasswordAction.class);
	private static final long serialVersionUID = 1L;
	private String email;
	private UserMaster user;
	@Autowired
	private IUserBo userBo;
	@Autowired
	private MailDispature mailDispature;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	
	
	public String execute(){
		session.put("forgetpassword","true");
		return SUCCESS;
		
	}
	public String sendPassword(){
		session.remove("forgetpassword");
		user = userBo.checkUser(null,getEmail());
		if(user != null){
			mailDispature.sendMail("nagesh.vejju@gmail.com", getEmail(), "Just subject", "Hello how are you");
			
			return SUCCESS;
		}
		return INPUT;
		
	}
	public void validate(){
		
	}
	
	public IUserBo getUserBo() {
		return userBo;
	}
	public void setUserBo(IUserBo userBo) {
		this.userBo = userBo;
	}
	public UserMaster getUser() {
		return user;
	}
	public void setUser(UserMaster user) {
		this.user = user;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

		
}
