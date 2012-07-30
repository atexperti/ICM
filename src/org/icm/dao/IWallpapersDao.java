/**
 * 
 */
package org.icm.dao;

import java.util.Collection;

import org.icm.model.WallpapersMaster;

/**
 * @author nageswararao.vejja
 *
 */
public interface IWallpapersDao {
	int addWallpapers(WallpapersMaster Wallpaper);
	
	int updateWallpapers(WallpapersMaster Wallpaper);
	
	WallpapersMaster getWallpapers(int id);
	
	Collection<Object> getWallpaperss();
	Collection<Object> getWallpaperss(int size);
	
	int deleteWallpapers(int id);

	Collection<Object> getWallpaperss(String Keyword,int count);
}
