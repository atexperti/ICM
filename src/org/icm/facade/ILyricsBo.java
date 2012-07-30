package org.icm.facade;

import java.util.Collection;
import java.util.HashMap;

import org.icm.model.LyricsMaster;

public interface ILyricsBo {
	Collection<LyricsMaster> getLyrics(HashMap<String, String> map);
}
