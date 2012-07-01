/**
 * 
 */
package org.icm.dao;

import java.util.Collection;

import org.icm.model.ChristianNeedsMaster;

/**
 * @author nageswararao.vejja
 *
 */
public interface IChristianNeedsDao {
	
	int addChristianNeeds(ChristianNeedsMaster ChristianNeeds);
	
	int updateChristianNeeds(ChristianNeedsMaster ChristianNeeds);
	
	ChristianNeedsMaster getChristianNeeds(int id);
	
	Collection<Object> getChristianNeedss();
	
	Collection<Object> getChristianNeedss(int size);
	
	int deleteChristianNeeds(int id);

	Collection<Object> getChristianNeedss(String Keyword);
}
