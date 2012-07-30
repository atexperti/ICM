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
import org.icm.model.WallpapersMaster;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nageswararao.vejja
 *
 */
public class WallpapersDaoImpl extends BaseDAOImpl implements IWallpapersDao {
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	@Transactional
	public int addWallpapers(WallpapersMaster wallpapers) {
		try {
			getEntityManager().persist(wallpapers);
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
	 * @see org.icm.dao.IWallpaperssDao#updateWallpapers(int)
	 */
	@Override
	@Transactional
	public int updateWallpapers(WallpapersMaster wallpapers) {
		try {
			getEntityManager().merge(wallpapers);
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
	 * @see org.icm.dao.IWallpaperssDao#getWallpapers(int)
	 */
	@Override
	@Transactional
	public WallpapersMaster getWallpapers(int id) {
		// TODO Auto-generated method stub
		WallpapersMaster Wallpapers = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<WallpapersMaster> from = criteriaQuery.from(WallpapersMaster.class);
			criteriaQuery.select(from);
			Predicate pred = from.get("id").in(id);
			criteriaQuery.where(pred);
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			Wallpapers = (WallpapersMaster) q1.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return Wallpapers;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Object> getWallpaperss() {
		// TODO Auto-generated method stub
		ArrayList<Object> wallpapers = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<WallpapersMaster> from = criteriaQuery.from(WallpapersMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.orderBy(criteriaBuilder.desc(from.get("lastModifiedDate")));
			Query q = getEntityManager().createQuery(criteriaQuery);
			wallpapers = (ArrayList<Object>) q.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return wallpapers;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Object> getWallpaperss(int size) {
		// TODO Auto-generated method stub
		ArrayList<Object> wallpapers = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<WallpapersMaster> from = criteriaQuery.from(WallpapersMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.orderBy(criteriaBuilder.desc(from.get("lastModifiedDate")));
			Query q = getEntityManager().createQuery(criteriaQuery);
			q.setMaxResults(size);
			wallpapers = (ArrayList<Object>) q.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return wallpapers;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public int deleteWallpapers(int id) {
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<WallpapersMaster> from = criteriaQuery.from(WallpapersMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.where(from.get("id").in(id));
			Query q = getEntityManager().createQuery(criteriaQuery);
			ArrayList<WallpapersMaster> wallpapers = (ArrayList<WallpapersMaster>) q
					.getResultList();
			System.out.println("Size of Wallpapers in DAO" + wallpapers.size());
			if (wallpapers != null && wallpapers.size() > 0) {
				for (WallpapersMaster wallpaper : wallpapers) {
					getEntityManager().remove(wallpaper);
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
	public Collection<Object> getWallpaperss(String keyword,int count) {
		// TODO Auto-generated method stub
		ArrayList<Object> events = null;
		try {

			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<WallpapersMaster> from = criteriaQuery.from(WallpapersMaster.class);

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
					from.<String> get("ocassion"), "%" + keyword + "%");
			type = criteriaBuilder.like(from.get("languageMaster")
					.<String> get("languageName"), "%" + keyword + "%");
			criteriaQuery.select(from).where(
					criteriaBuilder.or(name, caption, genre, keywords, artist,
							type,occasion,album));
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			if(count != 0)
				q1.setMaxResults(count);
			events = (ArrayList<Object>) q1.getResultList();

		} catch (Exception e) {
			System.out.println("error in seacrh database id and keyword: " + e);
			e.printStackTrace();

		}
		return events;
	}
}
