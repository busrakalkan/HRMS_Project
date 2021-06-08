package kodlamaio.hrms.business.concretes.cvInfo;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cvInfo.SkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.cvInfo.SkillsDao;
import kodlamaio.hrms.entities.concretes.cvInfo.ResumeSkill;


@Service
public class SkillManager implements SkillService{
	
	private SkillsDao skillDao;

	public SkillManager(SkillsDao skillDao) {
		super();
		this.skillDao = skillDao;
	}

	@Override
	public DataResult<List<ResumeSkill>> getAll() {
		return new SuccessDataResult<List<ResumeSkill>>(this.skillDao.findAll(),"Yetenekler Listelendi");
	}

	@Override
	public Result add(ResumeSkill skill) {
		this.skillDao.save(skill);
		return new SuccessResult("Yetenek Eklendi"); 
	}

}
