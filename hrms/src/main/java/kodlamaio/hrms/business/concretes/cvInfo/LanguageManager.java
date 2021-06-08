package kodlamaio.hrms.business.concretes.cvInfo;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cvInfo.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.cvInfo.LanguageDao;
import kodlamaio.hrms.entities.concretes.cvInfo.ResumeLanguage;


@Service
public class LanguageManager implements LanguageService{
	
	private LanguageDao language;

	public LanguageManager(LanguageDao language) {
		super();
		this.language = language;
	}

	@Override
	public DataResult<List<ResumeLanguage>> getAll() {
		return new SuccessDataResult<List<ResumeLanguage>>(this.language.findAll(),"Diller listelendi");
	}

	@Override
	public Result add(ResumeLanguage language) {
		this.language.save(language);
		return new SuccessResult("Dil eklendi");
	}

}
