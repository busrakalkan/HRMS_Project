package kodlamaio.hrms.business.abstracts.cvInfo;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvInfo.ResumeSchool;

public interface SchoolService {
	
	DataResult<List<ResumeSchool>> getAll();
    Result add(ResumeSchool school);
}
