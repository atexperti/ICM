package org.icm.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAccountAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private int msisdn;
	private String deviceModel;
	
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

	public int getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(int msisdn) {
		this.msisdn = msisdn;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}

}
