package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;


@RestController
@RequestMapping("/api/employer")
public class EmployerController {
	
	private EmployerService employerService;
	
	@Autowired
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@PostMapping("/login")
	public Result login(@RequestParam String email, String password) {
		return this.employerService.login(email,password);
	}

	@PostMapping("/register")
	public Result register(@RequestBody Employer employer, @RequestParam String repeatPassword) {
		return this.employerService.register(employer, repeatPassword);
	}
	
//	@DeleteMapping("/delete")
//	public Result delete(@RequestBody Employer employer) {
//		return this.employerService.delete(employer);
//	}
	
	

}
