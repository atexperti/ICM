/**
 * 
 */
package org.icm.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.icm.model.ChristianNeedsMaster;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nageswararao.vejja
 *
 */
public class ChristianNeedsDaoImpl extends BaseDAOImpl implements IChristianNeedsDao {
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	@Transactional
	public int addChristianNeeds(ChristianNeedsMaster christianNeeds) {
		try {
			getEntityManager().persist(christianNeeds);
		} catch (Exception e) {
			logger.error("Exception occured while adding device to device master"
					+ e);
			return 0;
		}
		return 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.dao.IChristianNeedssDao#updateChristianNeeds(int)
	 */
	@Override
	@Transactional
	public int updateChristianNeeds(ChristianNeedsMaster christianNeeds) {
		try {
			getEntityManager().merge(christianNeeds);
		} catch (Exception e) {
			logger.error("Exception occured while adding device to device master"
					+ e);
			return 0;
		}
		return 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.dao.IChristianNeedssDao#getChristianNeeds(int)
	 */
	@Override
	@Transactional
	public ChristianNeedsMaster getChristianNeeds(int id) {
		// TODO Auto-generated method stub
		ChristianNeedsMaster ChristianNeeds = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<ChristianNeedsMaster> from = criteriaQuery.from(ChristianNeedsMaster.class);
			criteriaQuery.select(from);
			Predicate pred = from.get("id").in(id);
			criteriaQuery.where(pred);
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			ChristianNeeds = (ChristianNeedsMaster) q1.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return ChristianNeeds;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Object> getChristianNeedss() {
		// TODO Auto-generated method stub
		ArrayList<Object> christianNeedss = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<ChristianNeedsMaster> from = criteriaQuery.from(ChristianNeedsMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.orderBy(criteriaBuilder.desc(from.get("lastModifiedDate")));
			Query q = getEntityManager().createQuery(criteriaQuery);
			christianNeedss = (ArrayList<Object>) q.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return christianNeedss;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Object> getChristianNeedss(int size) {
		// TODO Auto-generated method stub
		ArrayList<Object> christianNeedss = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<ChristianNeedsMaster> from = criteriaQuery.from(ChristianNeedsMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.orderBy(criteriaBuilder.desc(from.get("lastModifiedDate")));
			Query q = getEntityManager().createQuery(criteriaQuery);
			q.setMaxResults(size);
			christianNeedss = (ArrayList<Object>) q.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return christianNeedss;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public int deleteChristianNeeds(int id) {
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<ChristianNeedsMaster> from = criteriaQuery.from(ChristianNeedsMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.where(from.get("id").in(id));
			Query q = getEntityManager().createQuery(criteriaQuery);
			ArrayList<ChristianNeedsMaster> christianNeedss = (ArrayList<ChristianNeedsMaster>) q
					.getResultList();
			System.out.println("Size of ChristianNeeds in DAO" + christianNeedss.size());
			if (christianNeedss != null && christianNeedss.size() > 0) {
				for (ChristianNeedsMaster christianNeeds : christianNeedss) {
					getEntityManager().remove(christianNeeds);
				}
			}
		} catch (Exception e) {
			logger.error("Exception occured while deleting device form device master "
					+ e);
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Object> getChristianNeedss(String keyword) {
		// TODO Auto-generated method stub
		ArrayList<Object> events = null;
		try {

			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<ChristianNeedsMaster> from = criteriaQuery.from(ChristianNeedsMaster.class);

			Predicate name, caption, genre, keywords, artist, type,occasion,album;

			name = criteriaBuilder.like(from.<String> get("title"), "%"
					+ keyword + "%");
			caption = criteriaBuilder.like(from.<String> get("description"), "%"
					+ keyword + "%");
			genre = criteriaBuilder.like((from.<String> get("genre")), "%"
					+ keyword + "%");
			album = criteriaBuilder.like((from.<String> get("album")), "%"
					+ keyword + "%");
			keywords = criteriaBuilder.like(from.<String> get("keywords"), "%"
					+ keyword + "%");
			artist = criteriaBuilder.like(
					from.<String> get("artist"), "%" + keyword + "%");
			occasion = criteriaBuilder.like(
					from.<String> get("occasion"), "%" + keyword + "%");
			type = criteriaBuilder.like(from.get("languageMaster")
					.<String> get("languageName"), "%" + keyword + "%");
			criteriaQuery.select(from).where(
					criteriaBuilder.or(name, caption, genre, keywords, artist,
							type,occasion,album));
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			events = (ArrayList<Object>) q1.getResultList();

		} catch (Exception e) {
			System.out.println("error in seacrh database id and keyword: " + e);
			e.printStackTrace();

		}
		return events;
	}
}
