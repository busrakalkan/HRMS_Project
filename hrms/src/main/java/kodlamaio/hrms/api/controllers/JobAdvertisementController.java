package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobAdvertisement")
public class JobAdvertisementController {
	
	private JobAdvertisementService jobAdvertisementService;
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	@GetMapping("/getActive")
	public DataResult<List<JobAdvertisementDto>> getActive(){
		return this.jobAdvertisementService.getByActivated();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getByRelease")
	public DataResult<List<JobAdvertisementDto>> getByRelease(){
		return this.jobAdvertisementService.getByActivatedOrderByReleaseDateAsc();
	}
	@GetMapping("/getByDeadline")
	public DataResult<List<JobAdvertisementDto>> getByDeadline(){
		return this.jobAdvertisementService.getByActivatedOrderByDeadlineDateAsc();
	}
	
	
	@GetMapping("/getActiveAndByEmployer")
	public Result getByActivatedAndEmployer(@RequestParam String companyName) {
		return this.jobAdvertisementService.getByActivatedAndEmployer(companyName);
	}
	
	@GetMapping("/deactivateAdvertisement")
	public Result deactivateJobAdvertisement(@RequestParam Integer id) {
		return this.jobAdvertisementService.deactivateJobAdvertisement(id);
	}
	


}
