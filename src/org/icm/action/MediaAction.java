package org.icm.action;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.icm.facade.Constants;
import org.icm.facade.IMediaBo;
import org.icm.model.WallpapersMaster;
import org.springframework.core.io.Resource;

public class MediaAction extends BaseAction  {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(MediaAction.class);
	private Resource configLocation;
	private IMediaBo mediaBo;
	
	private String type;
	
	public void init(){
		try {
			super.init();

		} catch (Exception e) {
			logger.error(e);
		}
	}
	public String execute() {
		try{
			setActiveMenuId("media");
			String language = getLanguage();
			System.out.println("Language="+ language);
			//Get all the languages
			Collection<Object> languagesList = mediaBo.getLanguages();
			setLanguages(languagesList);

			HttpSession session = getRequest().getSession();
			//Get all the required information if its not there in session
			if(session.getAttribute(Constants.IMAGE_OF_THE_DAY) == null){
				Collection<Object> audios =  mediaBo.getMediass(language,Constants.AUDIO);
				session.setAttribute(Constants.AUDIO, audios);
	
				Collection<Object> videos =  mediaBo.getMediass(language,Constants.VIDEO);
				session.setAttribute(Constants.VIDEO, videos);
	
				WallpapersMaster wallpapersMaster = null;
				Collection<Object> imageCollection =  mediaBo.getMediass(language,Constants.IMAGES,1);
				if(imageCollection != null){
					Iterator<Object> imageIterator = imageCollection.iterator();
					while(imageIterator.hasNext()){
						wallpapersMaster = (WallpapersMaster)imageIterator.next();
					}
				}
				session.setAttribute(Constants.IMAGE_OF_THE_DAY, wallpapersMaster != null? wallpapersMaster.getTitle():"");
			}
			return SUCCESS;
		}catch(Exception e){
			logger.error(e);
			return ERROR;
		}
	}
	

	
	public void setConfigLocation(Resource configLocation) {
	
		this.configLocation = configLocation;
	}
	public Resource getConfigLocation() {
		return configLocation;
	}
	
	/**
	 * @return the mediaBo
	 */
	public IMediaBo getMediaBo() {
		return mediaBo;
	}
	/**
	 * @param mediaBo the mediaBo to set
	 */
	public void setMediaBo(IMediaBo mediaBo) {
		this.mediaBo = mediaBo;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
