package org.icm.facade;

import java.util.Collection;
import java.util.HashMap;

import org.icm.dao.ILyricsDao;
import org.icm.model.LyricsMaster;

public class LyricsBoImpl implements ILyricsBo{
	
	private ILyricsDao lyricsDao;
	public ILyricsDao getLyricsDao() {
		return lyricsDao;
	}
	public void setLyricsDao(ILyricsDao lyricsDao) {
		this.lyricsDao = lyricsDao;
	}
	@Override
	public Collection<LyricsMaster> getLyrics(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return lyricsDao.getLyrics(map);
	}
}
