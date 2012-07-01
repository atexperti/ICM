package org.icm.facade;

import org.icm.model.UserMaster;



public interface IUserBo {
	
	int addUser(UserMaster cust);
	int updateUser(int id);
	UserMaster getUser(int id);
	UserMaster checkUser(String uname, String email);
	UserMaster getUser(String uname, String pwd);
	int deleteUser(int id);

}
