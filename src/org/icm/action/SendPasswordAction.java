package org.icm.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.icm.facade.IUserBo;
import org.icm.mail.MailDispature;
import org.icm.model.UserMaster;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SendPasswordAction extends ActionSupport {
	/**
	 * 
	 */
	private static Logger logger = Logger.getLogger(SendPasswordAction.class);
	private static final long serialVersionUID = 1L;
	private String email;
	private String userName;
	private UserMaster user;
	@Autowired
	private IUserBo userBo;
	@Autowired
	private MailDispature mailDispature;
	private Map<String, Object> session = ActionContext.getContext()
			.getSession();

	public String execute() {

		user = userBo.checkUser(userName, getEmail());
		if (user != null) {
			session.remove("forgetpassword");
			mailDispature.sendMail("nagesh.vejju@gmail.com", getEmail(), "ICM",
					"your username is: " + user.getUserName()
							+ " and your password is: " + user.getPassword());

			return SUCCESS;
		}
		return INPUT;

	}

	public void validate() {

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
