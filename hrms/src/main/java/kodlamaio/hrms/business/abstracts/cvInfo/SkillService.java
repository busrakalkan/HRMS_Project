package kodlamaio.hrms.business.abstracts.cvInfo;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvInfo.ResumeSkill;

public interface SkillService {
	
	DataResult<List<ResumeSkill>> getAll();
    Result add(ResumeSkill skill);

}
