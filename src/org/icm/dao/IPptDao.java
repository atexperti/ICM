/**
 * 
 */
package org.icm.dao;

import java.util.Collection;

import org.icm.model.PptMaster;

/**
 * @author nageswararao.vejja
 *
 */
public interface IPptDao {
	int addPpt(PptMaster Ppt);
	
	int updatePpt(PptMaster Ppt);
	
	PptMaster getPpt(int id);
	
	Collection<Object> getPpts();
	
	Collection<Object> getPpts(int size);
	
	int deletePpt(int id);

	Collection<Object> getPpts(String Keyword);
}
