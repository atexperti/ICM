package org.icm.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.icm.facade.Constants;
import org.icm.facade.IMediaBo;
import org.icm.model.LanguageMaster;
import org.icm.model.WallpapersMaster;
import org.springframework.core.io.Resource;

public class HomeAction extends BaseAction  {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(HomeAction.class);
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
			
			//set to highlight the home menu 
			setActiveMenuId("home");
			
			Collection<Object> audios = new ArrayList<Object>();
			Collection<Object> videos = new ArrayList<Object>();
			Collection<Object> preview = new ArrayList<Object>();
			HttpSession session = getRequest().getSession();
			
			//Get all the languages
			Collection<Object> languagesList = mediaBo.getLanguages();
			setLanguages(languagesList);
			
			//Get all the required information if its not there in session
			if(session.getAttribute(Constants.AUDIO) == null)
			{
				//Get the first two latest updated audio and video files for each language
				Iterator<Object> iterator = languagesList.iterator();
				while(iterator.hasNext()){
					LanguageMaster languageMaster = (LanguageMaster)iterator.next();
					audios.addAll(mediaBo.getMediass(languageMaster.getLanguageName(),Constants.AUDIO,2));
					videos.addAll(mediaBo.getMediass(languageMaster.getLanguageName(),Constants.VIDEO,2));
				}
				
				//Get image of the day 
				Collection<Object> imageCollection =  mediaBo.getMedias(1,Constants.IMAGES);
				Iterator<Object> imageIterator = imageCollection.iterator();
				WallpapersMaster wallpapersMaster = null;
				while(imageIterator.hasNext()){
					wallpapersMaster = (WallpapersMaster)imageIterator.next();
				}
				
				//Get preview images data
				preview.addAll(mediaBo.getMedias(1, Constants.AUDIO));
				preview.addAll(mediaBo.getMedias(1, Constants.VIDEO));
				preview.addAll(mediaBo.getMedias(1, Constants.IMAGES));
				preview.addAll(mediaBo.getMedias(1, Constants.PPT));
				preview.addAll(mediaBo.getMedias(1, Constants.TEMPLATES));
				preview.addAll(mediaBo.getMedias(1, Constants.CHIRSTIANNEEDS));
	
	
				//Set all the information in session
				session.setAttribute(Constants.AUDIO, audios);
				session.setAttribute(Constants.VIDEO, videos);
				session.setAttribute(Constants.IMAGES, preview);
				session.setAttribute(Constants.IMAGE_OF_THE_DAY, wallpapersMaster.getTitle());
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
