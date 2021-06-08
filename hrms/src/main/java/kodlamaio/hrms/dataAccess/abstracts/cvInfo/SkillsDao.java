package kodlamaio.hrms.dataAccess.abstracts.cvInfo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.cvInfo.ResumeSkill;
import kodlamaio.hrms.entities.dtos.SkillDto;

public interface SkillsDao extends JpaRepository<ResumeSkill, Integer>{
	
	@Query("Select new kodlamaio.hrms.entities.dtos.SkillDto(s.skillName)"
			+ "From ResumeSkill s Inner Join s.resume r where r.id=:id")
	List<SkillDto> getSkills(int id);

}