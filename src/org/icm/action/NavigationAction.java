package org.icm.action;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.icm.facade.IMediaBo;

public class NavigationAction extends BaseAction{
	private static Logger logger = Logger.getLogger(NavigationAction.class);
	private IMediaBo mediaBo;

	public IMediaBo getMediaBo() {
		return mediaBo;
	}

	public void setMediaBo(IMediaBo mediaBo) {
		this.mediaBo = mediaBo;
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
			
			String menuId = getRequest().getParameter("menuID");
			System.out.println("menuId===========>"+menuId);
			setActiveMenuId(menuId);
			//Get all the languages
			Collection<Object> languagesList = mediaBo.getLanguages();
			setLanguages(languagesList);
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
}
