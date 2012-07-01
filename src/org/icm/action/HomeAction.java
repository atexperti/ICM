package org.icm.action;

import org.apache.log4j.Logger;
import org.icm.facade.IMediaBo;
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
