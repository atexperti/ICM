package org.icm.facade;

import java.util.List;

import org.apache.log4j.Logger;
import org.icm.dao.IUserDao;
import org.icm.model.UserMaster;

public class UserBoImpl implements IUserBo{

	private static Logger logger = Logger.getLogger(UserBoImpl.class);
	
	
	private IUserDao userDao;
	private UserMaster UserMaster;

	@Override
	public int addUser(UserMaster UserMaster) {
		int id = 0;
		try{
			logger.info("UserMaster obj" + UserMaster);
			
				id = userDao.addUser(UserMaster);
			
		}
		catch(Throwable tr){
			logger.error(tr);
		}
		return id;
	}

	@Override
	public int deleteUser(int id) {
		
		return 0;
	}

	@Override
	public UserMaster getUser(int id) {
		return userDao.getUser(id);
	}
	@Override
	public UserMaster getUser(String uname, String pwd) {
		try{
			// Retrieving UserMaster info from the DB
			logger.info(uname +"  "+pwd);
			List<UserMaster> custList = (List<UserMaster>) userDao.getUser(uname, pwd);
			System.out.println(custList.size());
			if(!custList.isEmpty()){
				UserMaster = custList.get(0);
				// Check if the UserMaster is existed and has valid msisdn
				if(UserMaster.getUserId() != 0){
					return UserMaster;
				}
			}
		}catch(Throwable tr){
			logger.error(tr);
		}
		return null;
	}
	
	@Override
	public int updateUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean isValidUser(int msisdn){
		return true;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	/**
	 * Getting UserMaster data by passing UserMaster name 
	 */
	@Override
	public UserMaster checkUser(String uname, String email) {
		try{
			List<UserMaster> custList = (List<UserMaster>) userDao.checkUser(uname, email);
			if(custList != null && !custList.isEmpty())		
			return custList.get(0);
		}catch(Throwable e){
			logger.error(e);
		}
		return null;
		
	}
	

}
