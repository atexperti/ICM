package org.icm.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.icm.facade.Constants;
import org.icm.facade.IEventsBo;
import org.icm.facade.IMediaBo;
import org.icm.model.EventMaster;

public class EventsAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(EventsAction.class);
	private IEventsBo eventsBo;
	private IMediaBo mediaBo;
	//Form fields start
	private String place;
	private String spLanguage;
	private String sortBy;
	private String keyword;
	private String region;
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getSpLanguage() {
		return spLanguage;
	}
	public void setSpLanguage(String spLanguage) {
		this.spLanguage = spLanguage;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	//Form fields end
	public IMediaBo getMediaBo() {
		return mediaBo;
	}
	public void setMediaBo(IMediaBo mediaBo) {
		this.mediaBo = mediaBo;
	}
	public IEventsBo getEventsBo() {
		return eventsBo;
	}
	public void setEventsBo(IEventsBo eventsBo) {
		this.eventsBo = eventsBo;
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
			List<String> placeDropDownData = new ArrayList<String>();
			List<String> spectatorLangDropDownData = new ArrayList<String>();
			List<String> regionDropDownData = new ArrayList<String>();
			List<EventMaster> eventMastersList = new ArrayList<EventMaster>();

			//set to highlight the events menu 
			setActiveMenuId("events");
			String language = getLanguage();
			System.out.println("Language="+ language);
			//Get all the languages
			Collection<Object> languagesList = mediaBo.getLanguages();
			setLanguages(languagesList);

			
			//Get all the events
			HashMap<String, String> predicates = new HashMap<String,String>();
			predicates.put("languageName", language);
			if(place != null && !"-1".equals(place)){
				predicates.put("place", place);
			}
			if(spLanguage != null && !"-1".equals(spLanguage)){
				predicates.put("spectatorLanguage", spLanguage);
			}
			
			if(keyword != null && !"".equals(keyword) && !"Keyword".equalsIgnoreCase(keyword)){
				predicates.put("keywords", keyword);
			}
			if(region != null && !"-1".equals(region)){
				predicates.put("region", region);
			}

			Collection<EventMaster> eventMasters = eventsBo.getEvents(predicates);
			for(EventMaster eventMaster: eventMasters){
				eventMastersList.add(eventMaster);
				placeDropDownData.add(eventMaster.getPlace());
				if(eventMaster.getSpectatorLanguage() != null){
					spectatorLangDropDownData.add(eventMaster.getSpectatorLanguage());
				}
				if(eventMaster.getRegion() != null){
					regionDropDownData.add(eventMaster.getSpectatorLanguage());
				}
				
			}
			if(sortBy != null && !"-1".equals(sortBy)){
				if("place Asc".equalsIgnoreCase(sortBy)){
					Collections.sort(eventMastersList, new PlaceComparator("Asc"));
				}else if("place Desc".equalsIgnoreCase(sortBy)){
					Collections.sort(eventMastersList, new PlaceComparator("Desc"));
				}else if("Language Desc".equalsIgnoreCase(sortBy)){
					Collections.sort(eventMastersList, new languageComparator("Desc"));
				}else if("Language Asc".equalsIgnoreCase(sortBy)){
					Collections.sort(eventMastersList, new languageComparator("Asc"));
				}else if("Region Desc".equalsIgnoreCase(sortBy)){
					Collections.sort(eventMastersList, new regionComparator("Desc"));
				}else if("Regioon Asc".equalsIgnoreCase(sortBy)){
					Collections.sort(eventMastersList, new regionComparator("Asc"));
				}
			}
			session.setAttribute(Constants.EVENS, eventMastersList);
			
			if(session.getAttribute("places") == null || isLanguageChanged()){
				Collections.sort(placeDropDownData);
				session.setAttribute("places", new TreeSet<String>(placeDropDownData));
			}
			if(session.getAttribute("spLanguages") == null || isLanguageChanged()){
				Collections.sort(spectatorLangDropDownData);
				session.setAttribute("spLanguages", new TreeSet<String>(spectatorLangDropDownData));
			}
			if(session.getAttribute("regions") == null || isLanguageChanged()){
				Collections.sort(regionDropDownData);
				session.setAttribute("regions", new TreeSet<String>(regionDropDownData));
			}
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
}
class PlaceComparator implements Comparator<EventMaster>{
	String type;
	PlaceComparator(String type){
		this.type = type;
	}
	@Override
	public int compare(EventMaster em1, EventMaster em2) {
		// TODO Auto-generated method stub
		if("Asc".equalsIgnoreCase(type))
			return em2.getPlace().compareTo(em1.getPlace());
		else
			return em1.getPlace().compareTo(em2.getPlace());
	}
	
}

class regionComparator implements Comparator<EventMaster>{
	String type;
	regionComparator(String type){
		this.type = type;
	}
	@Override
	public int compare(EventMaster em1, EventMaster em2) {
		// TODO Auto-generated method stub
		if(em2.getRegion() != null && em1.getRegion() != null){
			if("Asc".equalsIgnoreCase(type)){
				return em2.getRegion().compareTo(em1.getRegion());
			}else{
				return em1.getRegion().compareTo(em2.getRegion());
			}
		}
		return 0;
	}
	
}
class languageComparator implements Comparator<EventMaster>{
	String type;
	languageComparator(String type){
		this.type = type;
	}
	@Override
	public int compare(EventMaster em1, EventMaster em2) {
		// TODO Auto-generated method stub
			if(em2.getSpectatorLanguage() != null && em1.getSpectatorLanguage() != null){
				if("Asc".equalsIgnoreCase(type)){
					return em2.getSpectatorLanguage().compareTo(em1.getSpectatorLanguage());
				}else{
					return em1.getSpectatorLanguage().compareTo(em2.getSpectatorLanguage());
				}
			}
			return 0;
		}
}
