/**
 * 
 */
package org.icm.dao;

import java.util.Collection;

import org.icm.model.WebsiteTemplateMaster;

/**
 * @author nageswararao.vejja
 *
 */
public interface IWebsiteTemplateDao {
	int addWebsiteTemplate(WebsiteTemplateMaster websiteTemplate);
	
	int updateWebsiteTemplate(WebsiteTemplateMaster websiteTemplate);
	
	WebsiteTemplateMaster getWebsiteTemplate(int id);
	
	Collection<Object> getWebsiteTemplatess();
	
	Collection<Object> getWebsiteTemplatess(int size);
	
	int deleteWebsiteTemplate(int id);

	Collection<Object> getWebsiteTemplatess(String Keyword);
}
