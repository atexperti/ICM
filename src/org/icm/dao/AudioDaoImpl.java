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
import org.icm.model.AudioMaster;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nageswararao.vejja
 *
 */
public class AudioDaoImpl extends BaseDAOImpl implements IAudioDao {
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	@Transactional
	public int addAudio(AudioMaster Audio) {
		try {
			getEntityManager().persist(Audio);
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
	 * @see org.icm.dao.IAudiosDao#updateAudio(int)
	 */
	@Override
	@Transactional
	public int updateAudio(AudioMaster Audio) {
		try {
			getEntityManager().merge(Audio);
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
	 * @see org.icm.dao.IAudiosDao#getAudio(int)
	 */
	@Override
	@Transactional
	public AudioMaster getAudio(int id) {
		// TODO Auto-generated method stub
		AudioMaster audio = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<AudioMaster> from = criteriaQuery.from(AudioMaster.class);
			criteriaQuery.select(from);
			Predicate pred = from.get("id").in(id);
			criteriaQuery.where(pred);
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			audio = (AudioMaster) q1.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return audio;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Object> getAudios() {
		// TODO Auto-generated method stub
		ArrayList<Object> audios = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<AudioMaster> from = criteriaQuery.from(AudioMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.orderBy(criteriaBuilder.desc(from.get("lastModifiedDate")));
			Query q = getEntityManager().createQuery(criteriaQuery);
			audios = (ArrayList<Object>) q.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return audios;
	}
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Object> getAudios(int count) {
		// TODO Auto-generated method stub
		ArrayList<Object> audios = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<AudioMaster> from = criteriaQuery.from(AudioMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.orderBy(criteriaBuilder.desc(from.get("lastModifiedDate")));
			Query q = getEntityManager().createQuery(criteriaQuery);
			q.setMaxResults(count);
			audios = (ArrayList<Object>) q.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return audios;
	}


	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public int deleteAudio(int id) {
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<AudioMaster> from = criteriaQuery.from(AudioMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.where(from.get("id").in(id));
			Query q = getEntityManager().createQuery(criteriaQuery);
			ArrayList<AudioMaster> audios = (ArrayList<AudioMaster>) q
					.getResultList();
			System.out.println("Size of audio in DAO" + audios.size());
			if (audios != null && audios.size() > 0) {
				for (AudioMaster audio : audios) {
					getEntityManager().remove(audio);
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
	public Collection<Object> getAudios(String keyword) {
		// TODO Auto-generated method stub
		ArrayList<Object> events = null;
		try {

			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<AudioMaster> from = criteriaQuery.from(AudioMaster.class);

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
