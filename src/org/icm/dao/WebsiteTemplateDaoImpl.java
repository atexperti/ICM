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
import org.icm.model.WebsiteTemplateMaster;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nageswararao.vejja
 *
 */
public class WebsiteTemplateDaoImpl extends BaseDAOImpl implements IWebsiteTemplateDao {
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	@Transactional
	public int addWebsiteTemplate(WebsiteTemplateMaster websiteTemplate) {
		try {
			getEntityManager().persist(websiteTemplate);
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
	 * @see org.icm.dao.IWebsiteTemplatesDao#updateWebsiteTemplate(int)
	 */
	@Override
	@Transactional
	public int updateWebsiteTemplate(WebsiteTemplateMaster websiteTemplate) {
		try {
			getEntityManager().merge(websiteTemplate);
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
	 * @see org.icm.dao.IWebsiteTemplatesDao#getWebsiteTemplate(int)
	 */
	@Override
	@Transactional
	public WebsiteTemplateMaster getWebsiteTemplate(int id) {
		// TODO Auto-generated method stub
		WebsiteTemplateMaster WebsiteTemplate = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<WebsiteTemplateMaster> from = criteriaQuery.from(WebsiteTemplateMaster.class);
			criteriaQuery.select(from);
			Predicate pred = from.get("id").in(id);
			criteriaQuery.where(pred);
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			WebsiteTemplate = (WebsiteTemplateMaster) q1.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return WebsiteTemplate;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Object> getWebsiteTemplatess() {
		// TODO Auto-generated method stub
		ArrayList<Object> websiteTemplates = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<WebsiteTemplateMaster> from = criteriaQuery.from(WebsiteTemplateMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.orderBy(criteriaBuilder.desc(from.get("lastModifiedDate")));
			Query q = getEntityManager().createQuery(criteriaQuery);
			websiteTemplates = (ArrayList<Object>) q.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return websiteTemplates;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Object> getWebsiteTemplatess(int size) {
		// TODO Auto-generated method stub
		ArrayList<Object> websiteTemplates = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<WebsiteTemplateMaster> from = criteriaQuery.from(WebsiteTemplateMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.orderBy(criteriaBuilder.desc(from.get("lastModifiedDate")));
			Query q = getEntityManager().createQuery(criteriaQuery);
			q.setMaxResults(size);
			websiteTemplates = (ArrayList<Object>) q.getResultList();

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return websiteTemplates;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public int deleteWebsiteTemplate(int id) {
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<WebsiteTemplateMaster> from = criteriaQuery.from(WebsiteTemplateMaster.class);
			criteriaQuery.select(from);
			criteriaQuery.where(from.get("id").in(id));
			Query q = getEntityManager().createQuery(criteriaQuery);
			ArrayList<WebsiteTemplateMaster> websiteTemplates = (ArrayList<WebsiteTemplateMaster>) q
					.getResultList();
			System.out.println("Size of WebsiteTemplate in DAO" + websiteTemplates.size());
			if (websiteTemplates != null && websiteTemplates.size() > 0) {
				for (WebsiteTemplateMaster websiteTemplate : websiteTemplates) {
					getEntityManager().remove(websiteTemplate);
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
	public Collection<Object> getWebsiteTemplatess(String keyword) {
		// TODO Auto-generated method stub
		ArrayList<Object> events = null;
		try {

			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<WebsiteTemplateMaster> from = criteriaQuery.from(WebsiteTemplateMaster.class);

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
