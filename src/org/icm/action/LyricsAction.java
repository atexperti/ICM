package org.icm.action;

import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.icm.facade.Constants;
import org.icm.facade.ILyricsBo;
import org.icm.facade.IMediaBo;
import org.icm.model.LyricsMaster;

public class LyricsAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(LyricsAction.class);
	private IMediaBo mediaBo;
	private ILyricsBo lyricsBo;
	private String lyricId;
	private String keyWords;
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public String getLyricId() {
		return lyricId;
	}
	public void setLyricId(String lyricId) {
		this.lyricId = lyricId;
	}
	public IMediaBo getMediaBo() {
		return mediaBo;
	}
	public void setMediaBo(IMediaBo mediaBo) {
		this.mediaBo = mediaBo;
	}
	public ILyricsBo getLyricsBo() {
		return lyricsBo;
	}
	public void setLyricsBo(ILyricsBo lyricsBo) {
		this.lyricsBo = lyricsBo;
	}
	public void init(){
		try {
			super.init();
		} catch (Exception e) {
			logger.error(e);
		}
	}
	public String execute() {
		try{
			//Variables declaration
			HttpSession session = getRequest().getSession();

			//set to highlight the events menu 
			setActiveMenuId("lyrics");
			String language = getLanguage();
			System.out.println("Language="+ language);

			//Get all the languages
			Collection<Object> languagesList = mediaBo.getLanguages();
			setLanguages(languagesList);
			
			HashMap<String, String> predicates = new HashMap<String,String>();
			predicates.put("languageName", language);

			if(getKeyWords() != null && !"".equals(getKeyWords()) && !"Search Lyrics".equalsIgnoreCase(getKeyWords())){
				predicates.put("keywords", getKeyWords());
			}
			Collection<LyricsMaster> lyricsMasters = lyricsBo.getLyrics(predicates);
				
			session.setAttribute(Constants.LYRICS, lyricsMasters);

			//get lyric id from request parameter
			String lyricId = getLyricId();
			if(lyricsMasters == null || lyricsMasters.size() == 0){
				session.removeAttribute("textLyrics");
				session.removeAttribute("albumName");
			}
			for(LyricsMaster lyricsMaster : lyricsMasters){
				if(lyricId == null || "".equals(lyricId)){
					session.setAttribute("textLyrics", lyricsMaster.getLyrics());
					session.setAttribute("albumName", lyricsMaster.getAlbumName()!=null?lyricsMaster.getAlbumName():"");
					break;
				}else if(lyricsMaster != null && lyricId.equals(lyricsMaster.getLyricsId().toString())){
					session.setAttribute("textLyrics", lyricsMaster.getLyrics());
					session.setAttribute("albumName", lyricsMaster.getAlbumName()!=null?lyricsMaster.getAlbumName():"");
				}
			}
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
}
