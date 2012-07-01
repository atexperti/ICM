/**
 * 
 */
package org.icm.dao;

import java.util.Collection;

import org.icm.model.VideoMaster;

/**
 * @author nageswararao.vejja
 *
 */
public interface IVideoDao {
	int addVideo(VideoMaster Video);
	
	int updateVideo(VideoMaster Video);
	
	VideoMaster getVideo(int id);
	
	Collection<Object> getVideos();
	
	Collection<Object> getVideos(int size);
	
	int deleteVideo(int id);

	Collection<Object> getVideos(String Keyword);
}
