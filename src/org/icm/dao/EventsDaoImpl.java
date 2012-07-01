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
import org.icm.model.EventMaster;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nageswararao.vejja
 * 
 */
public class EventsDaoImpl extends BaseDAOImpl implements IEventsDao {

	private Logger logger = Logger.getLogger(this.getClass());

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.dao.IEventsDao#addEvent(org.icm.model.EventMaster)
	 */
	@Override
	@Transactional
	public int addEvent(EventMaster event) {
		try {
			getEntityManager().persist(event);
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
	 * @see org.icm.dao.IEventsDao#updateEvent(int)
	 */
	@Override
	@Transactional
	public int updateEvent(EventMaster event) {
		try {
			getEntityManager().merge(event);
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
	 * @see org.icm.dao.IEventsDao#getEvent(int)
	 */
	@Override
	@Transactional
	public EventMaster getEvent(int id) {
		// TODO Auto-generated method stub
		EventMaster event = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<EventMaster> from = criteriaQuery.from(EventMaster.class);
			criteriaQuery.select(from);
			Predicate pred = from.get("eventId").in(id);
			criteriaQuery.where(pred);
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			event = (EventMaster) q1.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return event;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.dao.IEventsDao#getEvents(java.util.HashMap)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<EventMaster> getEvents(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<EventMaster> events = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<EventMaster> from = criteriaQuery.from(EventMaster.class);
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
			events = (ArrayList<EventMaster>) q1.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return events;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<EventMaster> getEvents(String keyword) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<EventMaster> events = null;
		try {

			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<EventMaster> from = criteriaQuery.from(EventMaster.class);

			Predicate name, caption, genre, keywords, artist, type;

			name = criteriaBuilder.like(from.<String> get("eventName"), "%"
					+ keyword + "%");
			caption = criteriaBuilder.like(from.<String> get("category"), "%"
					+ keyword + "%");
			genre = criteriaBuilder.like((from.<String> get("place")), "%"
					+ keyword + "%");
			keywords = criteriaBuilder.like(from.<String> get("keywords"), "%"
					+ keyword + "%");
			artist = criteriaBuilder.like(
					from.<String> get("eventDescription"), "%" + keyword + "%");
			type = criteriaBuilder.like(from.get("languageMaster")
					.<String> get("languageName"), "%" + keyword + "%");
			criteriaQuery.select(from).where(
					criteriaBuilder.or(name, caption, genre, keywords, artist,
							type));
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			events = (ArrayList<EventMaster>) q1.getResultList();

		} catch (Exception e) {
			System.out.println("error in seacrh database id and keyword: " + e);
			e.printStackTrace();

		}
		return events;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.dao.IEventsDao#deleteEvent(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public int deleteEvent(int id) {
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<EventMaster> from = criteriaQuery.from(EventMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.where(from.get("eventId").in(id));
			Query q = getEntityManager().createQuery(criteriaQuery);
			ArrayList<EventMaster> events = (ArrayList<EventMaster>) q
					.getResultList();
			System.out.println("Size of events in DAO" + events.size());
			if (events != null && events.size() > 0) {
				for (EventMaster event : events) {
					getEntityManager().remove(event);
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

}
