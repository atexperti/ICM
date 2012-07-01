package org.icm.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.icm.model.UserMaster;
import org.springframework.transaction.annotation.Transactional;

public class UserDaoImpl extends BaseDAOImpl implements IUserDao{
	@Override
	@Transactional
	public int addUser(UserMaster cust) {
		Serializable id = getSession().save(cust);         
        return Integer.parseInt(id.toString());  
	}

	@Override
	public int deleteUser(int id) {
		
		return 0;
	}

	@Override
	@Transactional
	public UserMaster getUser(int id) {
		return (UserMaster)getSession().get(UserMaster.class, id);
	}

	@Override
	public int updateUser(int id) {
		
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<UserMaster> getUser(String uname, String pwd) {
		 Query query = getSession().createQuery("from UserMaster where userName= :userName and password= :password");
		 System.out.println(uname+":" +pwd);
		 query.setParameter("userName", uname);
		 query.setParameter("password", pwd);
		 List<UserMaster> users = query.list();
		 System.out.println(users.size());
		 return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<UserMaster> checkUser(String uname, String email) {
		
		if(uname !=null){
			Query query = getSession().createQuery("from UserMaster where userName= :userName or email= :email");
			 query.setParameter("userName", uname);
			 query.setParameter("email", email);
			 return query.list();
		} else {
			Query query = getSession().createQuery("from UserMaster where email= :email");
			 query.setParameter("email", email);
			 return query.list();
		}
	}
	
	

}
