package kodlamaio.hrms.business.abstracts.cvInfo;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvInfo.ResumeExperience;

public interface ExperienceService {

	DataResult<List<ResumeExperience>> getAll();
    Result add(ResumeExperience experince);
}
