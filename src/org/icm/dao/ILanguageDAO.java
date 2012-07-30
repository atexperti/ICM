package org.icm.dao;

import java.util.Collection;

import org.icm.model.LanguageMaster;

public interface ILanguageDAO {
	int addLanguage(LanguageMaster language);
	
	int updateLanguage(LanguageMaster language);

	Collection<Object> getLanguages();
}
