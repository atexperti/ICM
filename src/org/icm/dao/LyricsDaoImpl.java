/**
 * 
 */
package org.icm.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.icm.model.LyricsMaster;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nageswararao.vejja
 * 
 */
public class LyricsDaoImpl extends BaseDAOImpl implements ILyricsDao {

	private Logger logger = Logger.getLogger(this.getClass());

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.dao.ILyricsDao#addLyrics(org.icm.model.LyricsMaster)
	 */
	@Override
	@Transactional
	public int addLyrics(LyricsMaster Lyrics) {
		try {
			getEntityManager().persist(Lyrics);
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
	 * @see org.icm.dao.ILyricsDao#updateLyrics(int)
	 */
	@Override
	@Transactional
	public int updateLyrics(LyricsMaster Lyrics) {
		try {
			getEntityManager().merge(Lyrics);
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
	 * @see org.icm.dao.ILyricsDao#getLyrics(int)
	 */
	@Override
	@Transactional
	public LyricsMaster getLyrics(int id) {
		// TODO Auto-generated method stub
		LyricsMaster Lyrics = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<LyricsMaster> from = criteriaQuery.from(LyricsMaster.class);
			criteriaQuery.select(from);
			Predicate pred = from.get("LyricsId").in(id);
			criteriaQuery.where(pred);
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			Lyrics = (LyricsMaster) q1.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return Lyrics;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.dao.ILyricsDao#getLyrics(java.util.HashMap)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<LyricsMaster> getLyrics(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<LyricsMaster> Lyrics = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<LyricsMaster> from = criteriaQuery.from(LyricsMaster.class);
			criteriaQuery.select(from);
			List<Predicate> predicates = new ArrayList<Predicate>();
			Set<String> keys = map.keySet();
			for (String key : keys) {
				if ("languageName".equalsIgnoreCase(key)) {
					Predicate predicate = from.get("languageMaster").get(key)
							.in(map.get(key));
					predicates.add(predicate);
				} else {
					Predicate predicate = from.get(key).in(map.get(key));
					predicates.add(predicate);
				}
			}
			if (predicates.size() == 1)
				criteriaQuery.where(predicates.get(0));
			else
				criteriaQuery.where(criteriaBuilder.and(predicates
						.toArray(new Predicate[0])));
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			Lyrics = (ArrayList<LyricsMaster>) q1.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return Lyrics;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<LyricsMaster> getLyrics(String keyword) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<LyricsMaster> Lyrics = null;
		try {

			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<LyricsMaster> from = criteriaQuery.from(LyricsMaster.class);

			Predicate name, caption, genre, keywords, artist, type;

			name = criteriaBuilder.like(from.<String> get("title"), "%"
					+ keyword + "%");
			caption = criteriaBuilder.like(from.<String> get("lyrics"), "%"
					+ keyword + "%");
			genre = criteriaBuilder.like((from.<String> get("albumName")), "%"
					+ keyword + "%");
			keywords = criteriaBuilder.like(from.<String> get("keywords"), "%"
					+ keyword + "%");
			artist = criteriaBuilder.like(
					from.<String> get("artists"), "%" + keyword + "%");
			type = criteriaBuilder.like(from.get("languageMaster")
					.<String> get("languageName"), "%" + keyword + "%");
			criteriaQuery.select(from).where(
					criteriaBuilder.or(name, caption, genre, keywords, artist,
							type));
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			Lyrics = (ArrayList<LyricsMaster>) q1.getResultList();

		} catch (Exception e) {
			System.out.println("error in seacrh database id and keyword: " + e);
			e.printStackTrace();

		}
		return Lyrics;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.dao.ILyricsDao#deleteLyrics(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public int deleteLyrics(int id) {
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<LyricsMaster> from = criteriaQuery.from(LyricsMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.where(from.get("LyricsId").in(id));
			Query q = getEntityManager().createQuery(criteriaQuery);
			ArrayList<LyricsMaster> lyrics = (ArrayList<LyricsMaster>) q
					.getResultList();
			System.out.println("Size of Lyrics in DAO" + lyrics.size());
			if (lyrics != null && lyrics.size() > 0) {
				for (LyricsMaster lyric : lyrics) {
					getEntityManager().remove(lyric);
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
	public Collection<LyricsMaster> getLyrics() {
		// TODO Auto-generated method stub
		ArrayList<LyricsMaster> ppts = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<LyricsMaster> from = criteriaQuery.from(LyricsMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.orderBy(criteriaBuilder.desc(from.get("lastModifiedDate")));
			Query q = getEntityManager().createQuery(criteriaQuery);
			ppts = (ArrayList<LyricsMaster>) q.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return ppts;
	}
}
