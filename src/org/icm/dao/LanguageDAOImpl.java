package org.icm.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.icm.model.LanguageMaster;
import org.icm.model.LyricsMaster;
import org.springframework.transaction.annotation.Transactional;

public class LanguageDAOImpl extends BaseDAOImpl implements ILanguageDAO{

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	@Transactional
	public int addLanguage(LanguageMaster language) {
		// TODO Auto-generated method stub
		try{
			getEntityManager().persist(language);
		}catch(Exception e){
			logger.error("error occured while inserting Language Master" + e);
			return 0;
		}
		return 1;
	}

	@Override
	@Transactional
	public int updateLanguage(LanguageMaster language) {
		// TODO Auto-generated method stub
		try{
			getEntityManager().merge(language);
		}catch(Exception e){
			logger.error("error occured while updating Language Master" + e);
			return 0;
		}
		return 1;

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Object> getLanguages() {
		// TODO Auto-generated method stub
		ArrayList<Object> languages = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<LanguageMaster> from = criteriaQuery.from(LanguageMaster.class);
			criteriaQuery.select(from);
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			languages = (ArrayList<Object>)q1.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return languages;
	}

}
