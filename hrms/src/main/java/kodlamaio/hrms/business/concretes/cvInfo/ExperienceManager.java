package kodlamaio.hrms.business.concretes.cvInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cvInfo.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.cvInfo.ExperienceDao;
import kodlamaio.hrms.entities.concretes.cvInfo.ResumeExperience;


@Service
public class ExperienceManager implements ExperienceService{
	
	private ExperienceDao experienceDao;
	
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public DataResult<List<ResumeExperience>> getAll() {
		return new SuccessDataResult<List<ResumeExperience>>(this.experienceDao.findAll(),"İş deneyimleri listelendi");
	}

	@Override
	public Result add(ResumeExperience experince) {
		this.experienceDao.save(experince);
		return new SuccessResult("İş Deneyimi eklendi");
	}

}
