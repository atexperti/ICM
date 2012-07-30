/**
 * 
 */
package org.icm.dao;

import java.util.Collection;

import org.icm.model.AudioMaster;

/**
 * @author nageswararao.vejja
 *
 */
public interface IAudioDao {
	int addAudio(AudioMaster Audio);
	
	int updateAudio(AudioMaster Audio);
	
	AudioMaster getAudio(int id);
	
	Collection<Object> getAudios();
	Collection<Object> getAudios(int count);
	
	int deleteAudio(int id);

	Collection<Object> getAudios(String Keyword,int count);
}
