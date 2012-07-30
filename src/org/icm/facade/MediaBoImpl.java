/**
 * 
 */
package org.icm.facade;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.icm.dao.IAudioDao;
import org.icm.dao.IChristianNeedsDao;
import org.icm.dao.ILanguageDAO;
import org.icm.dao.IPptDao;
import org.icm.dao.IVideoDao;
import org.icm.dao.IWallpapersDao;
import org.icm.dao.IWebsiteTemplateDao;
import org.icm.model.AudioMaster;
import org.icm.model.ChristianNeedsMaster;
import org.icm.model.PptMaster;
import org.icm.model.VideoMaster;
import org.icm.model.WallpapersMaster;
import org.icm.model.WebsiteTemplateMaster;

/**
 * @author nageswararao.vejja
 * 
 */
public class MediaBoImpl implements IMediaBo {
	private Logger logger = Logger.getLogger(this.getClass());

	private IAudioDao audioDao;
	private IVideoDao videoDao;
	private ILanguageDAO languageDAO;
	public ILanguageDAO getLanguageDAO() {
		return languageDAO;
	}

	public void setLanguageDAO(ILanguageDAO languageDAO) {
		this.languageDAO = languageDAO;
	}

	public IAudioDao getAudioDao() {
		return audioDao;
	}

	public void setAudioDao(IAudioDao audioDao) {
		this.audioDao = audioDao;
	}

	public IVideoDao getVideoDao() {
		return videoDao;
	}

	public void setVideoDao(IVideoDao videoDao) {
		this.videoDao = videoDao;
	}

	public IWebsiteTemplateDao getWebsiteTemplateDao() {
		return websiteTemplateDao;
	}

	public void setWebsiteTemplateDao(IWebsiteTemplateDao websiteTemplateDao) {
		this.websiteTemplateDao = websiteTemplateDao;
	}

	public IPptDao getPptDao() {
		return pptDao;
	}

	public void setPptDao(IPptDao pptDao) {
		this.pptDao = pptDao;
	}

	public IChristianNeedsDao getChristianNeedsDao() {
		return christianNeedsDao;
	}

	public void setChristianNeedsDao(IChristianNeedsDao christianNeedsDao) {
		this.christianNeedsDao = christianNeedsDao;
	}

	public IWallpapersDao getWallpapersDao() {
		return wallpapersDao;
	}

	public void setWallpapersDao(IWallpapersDao wallpapersDao) {
		this.wallpapersDao = wallpapersDao;
	}

	private IWebsiteTemplateDao websiteTemplateDao;
	private IPptDao pptDao;
	private IChristianNeedsDao christianNeedsDao;
	private IWallpapersDao wallpapersDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.facade.IMediaBo#addMedia(java.lang.Object)
	 */
	@Override
	public int addMedia(Object media, String type) {
		int id = 0;
		// TODO Auto-generated method stub
		switch (type) {
		case Constants.AUDIO:

			try {
				logger.info("audio obj" + media);

				id = audioDao.addAudio((AudioMaster) media);

			} catch (Throwable tr) {
				logger.error(tr);
			}
			return id;
		case Constants.VIDEO:

			try {
				logger.info("video obj" + media);

				id = videoDao.addVideo((VideoMaster) media);

			} catch (Throwable tr) {
				logger.error(tr);
			}
			return id;
		case Constants.PPT:

			try {
				logger.info("ppt obj" + media);

				id = pptDao.addPpt((PptMaster) media);

			} catch (Throwable tr) {
				logger.error(tr);
			}
			return id;
		case Constants.IMAGES:

			try {
				logger.info("wallpapers obj" + media);

				id = wallpapersDao.addWallpapers((WallpapersMaster) media);

			} catch (Throwable tr) {
				logger.error(tr);
			}
			return id;
		case Constants.TEMPLATES:

			try {
				logger.info("wallpapers obj" + media);

				id = websiteTemplateDao.addWebsiteTemplate((WebsiteTemplateMaster) media);

			} catch (Throwable tr) {
				logger.error(tr);
			}
			return id;
		case Constants.CHIRSTIANNEEDS:

			try {
				logger.info("christian obj" + media);

				id = christianNeedsDao
						.addChristianNeeds((ChristianNeedsMaster) media);

			} catch (Throwable tr) {
				logger.error(tr);
			}
			return id;
		default:
			return 0;
		}
		// return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.facade.IMediaBo#updateMedia(java.lang.Object)
	 */
	@Override
	public int updateMedia(Object media, String type) {
		// TODO Auto-generated method stub
		int id = 0;
		// TODO Auto-generated method stub
		switch (type) {
		case Constants.AUDIO:

			try {
				logger.info("audio obj" + media);

				id = audioDao.updateAudio((AudioMaster) media);

			} catch (Throwable tr) {
				logger.error(tr);
			}
			return id;
		case Constants.VIDEO:

			try {
				logger.info("video obj" + media);

				id = videoDao.updateVideo((VideoMaster) media);

			} catch (Throwable tr) {
				logger.error(tr);
			}
			return id;
		case Constants.PPT:

			try {
				logger.info("ppt obj" + media);

				id = pptDao.updatePpt((PptMaster) media);

			} catch (Throwable tr) {
				logger.error(tr);
			}
			return id;
		case Constants.IMAGES:

			try {
				logger.info("wallpapers obj" + media);

				id = wallpapersDao.updateWallpapers((WallpapersMaster) media);

			} catch (Throwable tr) {
				logger.error(tr);
			}
			return id;
		case Constants.TEMPLATES:

			try {
				logger.info("wallpapers obj" + media);

				id = websiteTemplateDao.updateWebsiteTemplate((WebsiteTemplateMaster) media);

			} catch (Throwable tr) {
				logger.error(tr);
			}
			return id;
		case Constants.CHIRSTIANNEEDS:

			try {
				logger.info("christian obj" + media);

				id = christianNeedsDao
						.updateChristianNeeds((ChristianNeedsMaster) media);

			} catch (Throwable tr) {
				logger.error(tr);
			}
			return id;
		default:
			return 0;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.facade.IMediaBo#getMedia(int)
	 */
	@Override
	public Object getMedia(int id, String type) {
		// TODO Auto-generated method stub
		Object obj = null;
		switch (type) {
		case Constants.AUDIO:

			try {
				obj = audioDao.getAudio(id);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		case Constants.VIDEO:

			try {
				obj = videoDao.getVideo(id);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		case Constants.IMAGES:

			try {
				obj = wallpapersDao.getWallpapers(id);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		case Constants.TEMPLATES:

			try {
				obj = websiteTemplateDao.getWebsiteTemplate(id);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		case Constants.PPT:

			try {
				obj = pptDao.getPpt(id);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		case Constants.CHIRSTIANNEEDS:

			try {
				obj = christianNeedsDao.getChristianNeeds(id);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
		return obj;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.facade.IMediaBo#getMedias()
	 */
	@Override
	public Collection<Object> getMedias(String type) {
		// TODO Auto-generated method stub
		Collection<Object>  obj = null;
		switch (type) {
		case Constants.AUDIO:

			try {
				obj = audioDao.getAudios();
				//return DummyData.getAudios();
			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		case Constants.VIDEO:

			try {
				obj = videoDao.getVideos();
			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		case Constants.IMAGES:

			try {
				obj = wallpapersDao.getWallpaperss();
			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		case Constants.TEMPLATES:

			try {
				obj = websiteTemplateDao.getWebsiteTemplatess();

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		case Constants.PPT:

			try {
				obj = pptDao.getPpts();

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		case Constants.CHIRSTIANNEEDS:

			try {
				obj = christianNeedsDao.getChristianNeedss();

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		return obj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.facade.IMediaBo#getMedias(int)
	 */
	@Override
	public Collection<Object> getMedias(int count, String type) {
		// TODO Auto-generated method stub
				Collection<Object>  obj = null;
				switch (type) {
				case Constants.AUDIO:

					try {
						obj = audioDao.getAudios(count);

					} catch (Exception e) {
						logger.error("Exception occured while getting promotionalContent "
								+ e);
						e.printStackTrace();
					}
					break;
				case Constants.VIDEO:

					try {
						obj = videoDao.getVideos(count);

					} catch (Exception e) {
						logger.error("Exception occured while getting promotionalContent "
								+ e);
						e.printStackTrace();
					}
					break;
				case Constants.IMAGES:

					try {
						obj = wallpapersDao.getWallpaperss(count);

					} catch (Exception e) {
						logger.error("Exception occured while getting promotionalContent "
								+ e);
						e.printStackTrace();
					}
					break;
				case Constants.TEMPLATES:

					try {
						obj = websiteTemplateDao.getWebsiteTemplatess(count);

					} catch (Exception e) {
						logger.error("Exception occured while getting promotionalContent "
								+ e);
						e.printStackTrace();
					}
					break;
				case Constants.PPT:

					try {
						obj = pptDao.getPpts(count);

					} catch (Exception e) {
						logger.error("Exception occured while getting promotionalContent "
								+ e);
						e.printStackTrace();
					}
					break;
					
				case Constants.CHIRSTIANNEEDS:

					try {
						obj = christianNeedsDao.getChristianNeedss(count);

					} catch (Exception e) {
						logger.error("Exception occured while getting promotionalContent "
								+ e);
						e.printStackTrace();
					}
					break;

				default:
					break;
				}
				return obj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.facade.IMediaBo#deleteAudio(int)
	 */
	@Override
	public int deleteMedia(int id, String type) {
		// TODO Auto-generated method stub
		int flag = 0;
		// TODO Auto-generated method stub
		switch (type) {
		case Constants.AUDIO:

			try {

				flag = audioDao.deleteAudio(id);

			} catch (Throwable tr) {
				logger.error(tr);
			}
			return flag;
		case Constants.VIDEO:

			try {

				flag = videoDao.deleteVideo(id);

			} catch (Throwable tr) {
				logger.error(tr);
			}
			return flag;
		case Constants.PPT:

			try {

				flag = pptDao.deletePpt(id);

			} catch (Throwable tr) {
				logger.error(tr);
			}
			return flag;
		case Constants.IMAGES:

			try {

				flag = wallpapersDao.deleteWallpapers(id);

			} catch (Throwable tr) {
				logger.error(tr);
			}
			return flag;
		case Constants.TEMPLATES:

			try {

				id = websiteTemplateDao.deleteWebsiteTemplate(id);

			} catch (Throwable tr) {
				logger.error(tr);
			}
			return id;
		case Constants.CHIRSTIANNEEDS:

			try {

				flag = christianNeedsDao.deleteChristianNeeds(id);

			} catch (Throwable tr) {
				logger.error(tr);
			}
			return flag;
		default:
			return 0;
		}
	}

	@Override
	public Collection<Object> getMediass(String Keyword, String type) {
		// TODO Auto-generated method stub
		return getMediass(Keyword, type, 0);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.facade.IMediaBo#getMediass(java.lang.String)
	 */
	@Override
	public Collection<Object> getMediass(String Keyword, String type, int count) {
		// TODO Auto-generated method stub
		Collection<Object>  obj = null;
		switch (type) {
		case Constants.AUDIO:

			try {
				obj = audioDao.getAudios(Keyword,count);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		case Constants.VIDEO:

			try {
				obj = videoDao.getVideos(Keyword,count);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		case Constants.IMAGES:

			try {
				obj = wallpapersDao.getWallpaperss(Keyword,count);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		case Constants.TEMPLATES:

			try {
				obj = websiteTemplateDao.getWebsiteTemplatess(Keyword);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		case Constants.PPT:

			try {
				obj = pptDao.getPpts(Keyword);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
			
		case Constants.CHIRSTIANNEEDS:

			try {
				obj = christianNeedsDao.getChristianNeedss(Keyword);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
		return obj;
	}

	@Override
	public Collection<Object> getLanguages() {
		// TODO Auto-generated method stub
		return languageDAO.getLanguages();
	}
}
