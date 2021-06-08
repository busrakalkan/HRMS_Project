package kodlamaio.hrms.dataAccess.abstracts.cvInfo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.cvInfo.ResumeSchool;
import kodlamaio.hrms.entities.dtos.SchoolDto;


public interface SchollDao extends JpaRepository<ResumeSchool, Integer>{
	@Query("Select new kodlamaio.hrms.entities.dtos.SchoolDto(s.school,s.degree, s.department, s.startedDate, s.endedDate)"
			+ "From ResumeSchool s Inner Join s.resume r where r.id=:id Order By s.endedDate DESC")
	List<SchoolDto> getSchoolsOrderByEndedDateDesc(int id);
}
