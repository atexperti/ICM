/**
 * 
 */
package org.icm.facade;

import java.util.Collection;

/**
 * @author nageswararao.vejja
 * 
 */
public interface IMediaBo {
	
	int addMedia(Object media, String type);

	int updateMedia(Object media, String type);

	Object getMedia(int id, String type);

	Collection<Object> getMedias(String type);

	Collection<Object> getMedias(int count, String type);

	int deleteMedia(int id, String type);

	Collection<Object> getMediass(String Keyword, String type);
}
