package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{
	
	boolean existsJobSeekerByTc(Integer tc);
	boolean existsJobSeekerByEmail(String email);
	JobSeeker getByEmailAndPassword(String email,String password);

}