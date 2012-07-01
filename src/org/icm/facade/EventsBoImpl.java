/**
 * 
 */
package org.icm.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.icm.dao.IEventsDao;
import org.icm.model.EventMaster;

/**
 * @author nageswararao.vejja
 * 
 */
public class EventsBoImpl implements IEventsBo {

	private Logger logger = Logger.getLogger(this.getClass());
	
	
	
	private IEventsDao eventsDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.dao.IEventsDao#addEvent(org.icm.model.EventMaster)
	 */
	@Override
	public int addEvent(EventMaster event) {
		int id = 0;
		try{
			logger.info("EventMaster obj" + event);
			
				id = eventsDao.addEvent(event);
			
		}
		catch(Throwable tr){
			logger.error(tr);
		}
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.dao.IEventsDao#updateEvent(int)
	 */
	@Override
	public int updateEvent(EventMaster event) {
		int id = 0;
		try{
			logger.info("EventMaster obj" + event);
			
				id = eventsDao.updateEvent(event);
			
		}
		catch(Throwable tr){
			logger.error(tr);
		}
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.dao.IEventsDao#getEvent(int)
	 */
	@Override
	public EventMaster getEvent(int id) {
		// TODO Auto-generated method stub
		EventMaster event = null;
		try {
			event = eventsDao.getEvent(id);

		} catch (Exception e) {
			logger.error("Exception occured while getting promotionalContent "
					+ e);
			e.printStackTrace();
		}
		return event;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.dao.IEventsDao#getEvents(java.util.HashMap)
	 */
	@Override
	public Collection<EventMaster> getEvents(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<EventMaster> events = null;
		try{
			events = (ArrayList<EventMaster>) eventsDao.getEvents(map);
		} catch(Throwable tr){
			logger.error(tr);
		}
		return events;
	}

	@Override
	public Collection<EventMaster> getEvents(String keyword) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<EventMaster> events = null;
		try {

			events = (ArrayList<EventMaster>) eventsDao.getEvents(keyword);

		} catch(Throwable tr){
			logger.error(tr);
		}
		return events;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.dao.IEventsDao#deleteEvent(int)
	 */
	@Override
	public int deleteEvent(int id) {
		int flag = 0;
		try{
			logger.info("EventMaster obj" + id);
			
			flag = eventsDao.deleteEvent(id);
			
		}
		catch(Throwable tr){
			logger.error(tr);
		}
		return flag;
	}

}
