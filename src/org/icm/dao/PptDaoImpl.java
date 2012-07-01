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
import org.icm.model.PptMaster;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nageswararao.vejja
 *
 */
public class PptDaoImpl extends BaseDAOImpl implements IPptDao {
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	@Transactional
	public int addPpt(PptMaster ppt) {
		try {
			getEntityManager().persist(ppt);
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
	 * @see org.icm.dao.IPptsDao#updatePpt(int)
	 */
	@Override
	@Transactional
	public int updatePpt(PptMaster ppt) {
		try {
			getEntityManager().merge(ppt);
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
	 * @see org.icm.dao.IPptsDao#getPpt(int)
	 */
	@Override
	@Transactional
	public PptMaster getPpt(int id) {
		// TODO Auto-generated method stub
		PptMaster Ppt = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<PptMaster> from = criteriaQuery.from(PptMaster.class);
			criteriaQuery.select(from);
			Predicate pred = from.get("id").in(id);
			criteriaQuery.where(pred);
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			Ppt = (PptMaster) q1.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return Ppt;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Object> getPpts() {
		// TODO Auto-generated method stub
		ArrayList<Object> ppts = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<PptMaster> from = criteriaQuery.from(PptMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.orderBy(criteriaBuilder.desc(from.get("lastModifiedDate")));
			Query q = getEntityManager().createQuery(criteriaQuery);
			ppts = (ArrayList<Object>) q.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return ppts;
	}
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Object> getPpts(int size) {
		// TODO Auto-generated method stub
		ArrayList<Object> ppts = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<PptMaster> from = criteriaQuery.from(PptMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.orderBy(criteriaBuilder.desc(from.get("lastModifiedDate")));
			Query q = getEntityManager().createQuery(criteriaQuery);
			q.setMaxResults(size);
			ppts = (ArrayList<Object>) q.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return ppts;
	}
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public int deletePpt(int id) {
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<PptMaster> from = criteriaQuery.from(PptMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.where(from.get("id").in(id));
			Query q = getEntityManager().createQuery(criteriaQuery);
			ArrayList<PptMaster> ppts = (ArrayList<PptMaster>) q
					.getResultList();
			System.out.println("Size of Ppt in DAO" + ppts.size());
			if (ppts != null && ppts.size() > 0) {
				for (PptMaster ppt : ppts) {
					getEntityManager().remove(ppt);
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
	public Collection<Object> getPpts(String keyword) {
		// TODO Auto-generated method stub
		ArrayList<Object> events = null;
		try {

			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<PptMaster> from = criteriaQuery.from(PptMaster.class);

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
