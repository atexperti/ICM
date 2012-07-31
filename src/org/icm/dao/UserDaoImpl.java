package org.icm.dao;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
		/* Query query = getSession().createQuery("from UserMaster where userName=:userName and password=:password");
		 System.out.println(uname+":" +pwd);
		 query.setParameter("userName", uname);
		 query.setParameter("password", pwd);
		 return query.list();*/
		try{
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();

		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<UserMaster> from = criteriaQuery.from(UserMaster.class);
		Predicate userNameCondition = null;
		Predicate passwordCondition = null;
		userNameCondition = from.get("userName").in(uname);
		passwordCondition = from.get("password").in(pwd);
		criteriaQuery.select(from);
		criteriaQuery.where(passwordCondition, userNameCondition);

		javax.persistence.Query q = getEntityManager().createQuery(criteriaQuery);
		Collection<UserMaster> cmsusers = (Collection<UserMaster>) q.getResultList();
		return cmsusers;
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
			throw e;
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<UserMaster> checkUser(String uname, String email) {
		try{
		if(uname !=null){
			Query query = getSession().createQuery("from UserMaster where userName= :userName or email= :email");
			 query.setParameter("userName", uname);
			 query.setParameter("email", email);
			 return query.list();
		} else {
			Query query = getSession().createQuery("from UserMaster where email= :email");
			 query.setParameter("email", email);
			 return query.list();
		}}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}
	
	

}
