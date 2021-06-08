package kodlamaio.hrms.dataAccess.abstracts.cvInfo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.cvInfo.ResumeExperience;
import kodlamaio.hrms.entities.dtos.ExperienceDto;

public interface ExperienceDao extends JpaRepository<ResumeExperience, Integer>{

	@Query("Select new kodlamaio.hrms.entities.dtos.ExperienceDto(e.companyName, e.position, e.startedDate, e.endedDate) "
			+ "From ResumeExperience e Inner Join e.resume r where r.id=:id Order By e.endedDate DESC")
	List<ExperienceDto> getExperiencesOrderByEndedDateDesc(int id);
}
