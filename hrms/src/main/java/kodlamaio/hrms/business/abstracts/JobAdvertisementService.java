package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisementDto>> getByActivated();
	DataResult<List<JobAdvertisementDto>> getByActivatedOrderByReleaseDateAsc();
	DataResult<List<JobAdvertisementDto>> getByActivatedOrderByDeadlineDateAsc();
	
	DataResult<List<JobAdvertisementDto>> getByActivatedAndEmployer(String companyName);
	Result deactivateJobAdvertisement(Integer id);

}
