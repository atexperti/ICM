package org.icm.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1353595244301441731L;
	private Map<String, Object> session;

	public String execute() {
		session = ActionContext.getContext().getSession();
		// if (session.get("Nextel_loggedIn")!=null){

		session.clear();
		return SUCCESS;
		// }
		// else
		// return ERROR;
	}

}
