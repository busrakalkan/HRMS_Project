package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;


@RestController
@RequestMapping("/api/jobSeeker")
public class JobSeekerController {
	private JobSeekerService jobSeekerService;
	
	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll(){
		return this.jobSeekerService.getAll();
	}
	
	@PostMapping("/login")
	public Result login(@RequestParam String email, String password) {
		return this.jobSeekerService.login(email,password);
	}

	@PostMapping("/register")
	public Result register(@RequestBody JobSeeker jobSeeker, @RequestParam String repeatPassword) {
		return this.jobSeekerService.register(jobSeeker, repeatPassword);
	}
//	@DeleteMapping("/delete")
//	public Result delete(@RequestBody JobSeeker jobSeeker) {
//		return this.jobSeekerService.delete(jobSeeker);
//	}
	

}
