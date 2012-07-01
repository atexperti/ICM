package org.icm.facade;

import java.beans.Introspector;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

public class LoadConfig implements ServletContextListener {
	private static Logger logger = Logger.getLogger(LoadConfig.class);
	public void contextInitialized(ServletContextEvent event) {
		try{
		/*	
			logger.info("calling servlet context listener");
			ServletContext context = event.getServletContext();
			JAXBContext jContext = JAXBContext.newInstance(Layout.class);
			Unmarshaller unmarshaller = jContext.createUnmarshaller();
			InputStream in = context.getResourceAsStream("/WEB-INF/classes/resources/layout.xml");
			Layout lout = (Layout) unmarshaller.unmarshal(in);
			context.setAttribute("layoutPages", new LayoutPages(lout));
			*/
			LogFactory.release(Thread.currentThread().getContextClassLoader());
			Introspector.flushCaches();
		}catch(Exception e){
			logger.info(e);
		}
		
	}

	public void contextDestroyed(ServletContextEvent event) {

	}
}
