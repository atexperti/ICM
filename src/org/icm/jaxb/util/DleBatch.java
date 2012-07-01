package org.icm.jaxb.util;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="dle-batch")
@XmlAccessorType(XmlAccessType.FIELD)
public class DleBatch {

	@XmlElement(name="download-item")
	@XmlElementWrapper(name="download-items")
	private ArrayList<DownloadItem> downloadItems;

	public ArrayList<DownloadItem> getDownloadItems() {
		return downloadItems;
	}

	public void setDownloadItems(ArrayList<DownloadItem> downloadItems) {
		this.downloadItems = downloadItems;
	}
	
}
