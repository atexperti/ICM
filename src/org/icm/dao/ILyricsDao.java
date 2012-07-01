/**
 * 
 */
package org.icm.dao;

import java.util.Collection;
import java.util.HashMap;

import org.icm.model.LyricsMaster;

/**
 * @author nageswararao.vejja
 *
 */
public interface ILyricsDao {
	
	int addLyrics(LyricsMaster lyrics);
	
	int updateLyrics(LyricsMaster lyrics);
	
	LyricsMaster getLyrics(int id);
	
	Collection<LyricsMaster> getLyrics(HashMap<String, String> map);
	
	Collection<LyricsMaster> getLyrics();
	
	int deleteLyrics(int id);

	Collection<LyricsMaster> getLyrics(String Keyword);

}
