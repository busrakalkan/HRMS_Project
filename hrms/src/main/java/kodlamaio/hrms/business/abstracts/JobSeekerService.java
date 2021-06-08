package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	
	DataResult<List<JobSeeker>> getAll();
	Result login(String email, String password); 
	Result register(JobSeeker jobSeeker,String emailRepeat); 
	Result delete(JobSeeker jobSeeker);
	DataResult<JobSeeker> getByJobSeekerId(Integer id);
	 
	
}
