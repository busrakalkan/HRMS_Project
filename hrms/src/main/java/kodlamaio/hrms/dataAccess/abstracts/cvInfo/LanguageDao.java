package kodlamaio.hrms.dataAccess.abstracts.cvInfo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.cvInfo.ResumeLanguage;
import kodlamaio.hrms.entities.dtos.LanguageDto;

public interface LanguageDao extends JpaRepository<ResumeLanguage, Integer>{

	@Query("Select new kodlamaio.hrms.entities.dtos.LanguageDto(l.language, l.languageLevel)"
			+ "From ResumeLanguage l Inner Join l.resume r where r.id=:id")
	List<LanguageDto> getLanguages(int id);
}