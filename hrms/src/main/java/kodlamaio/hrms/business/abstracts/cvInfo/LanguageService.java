package kodlamaio.hrms.business.abstracts.cvInfo;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvInfo.ResumeLanguage;

public interface LanguageService {
	
	DataResult<List<ResumeLanguage>> getAll();
    Result add(ResumeLanguage language);
}
