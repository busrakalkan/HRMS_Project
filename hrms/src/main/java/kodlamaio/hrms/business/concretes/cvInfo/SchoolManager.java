package kodlamaio.hrms.business.concretes.cvInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cvInfo.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.cvInfo.SchollDao;
import kodlamaio.hrms.entities.concretes.cvInfo.ResumeSchool;


@Service
public class SchoolManager implements SchoolService{
	
	private SchollDao schoolDao;
	
	@Autowired
	public SchoolManager(SchollDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public DataResult<List<ResumeSchool>> getAll() {
		return new SuccessDataResult<List<ResumeSchool>>(this.schoolDao.findAll(),"Okulların listesi");
	}

	@Override
	public Result add(ResumeSchool school) {
		this.schoolDao.save(school);
		return new SuccessResult("Okul eklendi");
	}

}
