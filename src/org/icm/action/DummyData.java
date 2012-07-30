package org.icm.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.icm.dao.BaseDAOImpl;
import org.icm.model.AudioMaster;
import org.icm.model.LanguageMaster;
import org.icm.model.VideoMaster;
import org.icm.model.WallpapersMaster;

public class DummyData {

	/**
	 * @param args
	 */
	public static Collection<Object> getAudios() {
		// TODO Auto-generated method stub
		//Transaction transaction = session.beginTransaction();
		AudioMaster audioMaster = null;
		Collection<Object> collection = new ArrayList<>();
		int i = 1;
		while(i < 6){
			audioMaster = new AudioMaster();
			audioMaster.setAlbum("Album "+ i);
			audioMaster.setArtist("Artist "+i);
			audioMaster.setDescription("Description "+ i);
			audioMaster.setGenre("Gener" + i);
			audioMaster.setKeywords("Key Words "+ i);
			audioMaster.setLastModifiedDate(new Date());
			audioMaster.setOcassion("Ocassion " + i);
			audioMaster.setPreview("preview "+ i);
			audioMaster.setProviderName("providerName " + i);
			audioMaster.setPurchaseInfo("purchaseInfo "+i);
			audioMaster.setThumbnail("thumbnail "+ i);
			audioMaster.setTitle("title "+i);
			audioMaster.setLanguageMaster(new LanguageMaster("English",new Date()));
			collection.add(audioMaster);
			i++;
		}
		return collection;
	}

	public static Collection<Object> getVideos() {
		// TODO Auto-generated method stub
		//Transaction transaction = session.beginTransaction();
		VideoMaster videoMaster = null;
		Collection<Object> collection = new ArrayList<>();
		int i = 1;
		while(i < 6){
			videoMaster = new VideoMaster();
			videoMaster.setAlbum("album"+i);
			videoMaster.setArtist("artist"+i);
			videoMaster.setDescription("description"+i);
			videoMaster.setGenre("genre"+i);
			videoMaster.setId(i);
			videoMaster.setKeywords("keywords"+i);
			videoMaster.setLastModifiedDate(new Date());
			videoMaster.setOcassion("ocassion"+i);
			videoMaster.setPreview("preview"+i);
			videoMaster.setProviderName("providerName"+i);
			videoMaster.setPurchaseInfo("purchaseInfo"+i);
			videoMaster.setThumbnail("thumbnail"+i);
			videoMaster.setTitle("title"+i);
			collection.add(videoMaster);
			i++;
		}
		return collection;
	}

	public static Collection<Object> getImages() {
		Collection<Object> collection = new ArrayList<>();
		int i =1;
		WallpapersMaster wallpapersMaster = null;
		while(i < 4){
			wallpapersMaster = new WallpapersMaster();
			wallpapersMaster.setAlbum("album"+i);
			wallpapersMaster.setArtist("artist"+i);
			wallpapersMaster.setDescription("description"+i);
			wallpapersMaster.setGenre("genre"+i);
			wallpapersMaster.setId(i);
			wallpapersMaster.setKeywords("keywords"+i);
			wallpapersMaster.setLastModifiedDate(new Date());
			wallpapersMaster.setOcassion("ocassion"+i);
			wallpapersMaster.setPreview("preview"+i);
			wallpapersMaster.setProviderName("providerName"+i);
			wallpapersMaster.setPurchaseInfo("purchaseInfo"+i);
			wallpapersMaster.setThumbnail("images/images/"+i+".jpg");
			wallpapersMaster.setTitle("title"+i);
			collection.add(wallpapersMaster);
			i++;
		}
		return collection;
	}
}

