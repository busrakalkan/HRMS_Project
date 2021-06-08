package kodlamaio.hrms.api.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.business.abstracts.cvInfo.ExperienceService;
import kodlamaio.hrms.business.abstracts.cvInfo.LanguageService;
import kodlamaio.hrms.business.abstracts.cvInfo.SchoolService;
import kodlamaio.hrms.business.abstracts.cvInfo.SkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.concretes.cvInfo.ResumeExperience;
import kodlamaio.hrms.entities.concretes.cvInfo.ResumeLanguage;
import kodlamaio.hrms.entities.concretes.cvInfo.ResumeSchool;
import kodlamaio.hrms.entities.concretes.cvInfo.ResumeSkill;
import kodlamaio.hrms.entities.dtos.ResumeDto;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {
	
	private ResumeService resumeService;
	private SkillService skillService;
	private SchoolService schoolService;
	private LanguageService languageService;
	private ExperienceService experienceService;
	
	@Autowired
	public ResumeController(ResumeService resumeService,SkillService skillService,
			SchoolService schoolService,LanguageService languageService,ExperienceService experienceService) {
		super();
		this.resumeService = resumeService;
		this.skillService = skillService;
		this.schoolService = schoolService;
		this.languageService = languageService;
		this.experienceService = experienceService;
	}


	@GetMapping("/getAllResume")
	public DataResult<List<Resume>> getAllResume(){
		return this.resumeService.getAll();
	}
	
	@GetMapping("/skill/getAllSkills")
	public DataResult<List<ResumeSkill>> getAllSkills(){
		return this.skillService.getAll();
	}
	
	@GetMapping("/school/getAllSchool")
	public DataResult<List<ResumeSchool>> getAllSchool(){
		return this.schoolService.getAll();
	}
	
	@GetMapping("/language/getAllLanguage")
	public DataResult<List<ResumeLanguage>> getAllLanguage(){
		return this.languageService.getAll();
	}
	
	@GetMapping("/experince/getAllExperience")
	public DataResult<List<ResumeExperience>> getAllExperience(){
		return this.experienceService.getAll();
	}
	
	
	@PostMapping("/addResume")
	public Result addResume(@RequestBody Resume resume) {
		return this.resumeService.add(resume);
	}
	
	@PostMapping("/skill/addSkill")
	public Result addSkill(@RequestBody ResumeSkill skill) {
		return this.skillService.add(skill);
	}
	@PostMapping("/school/addScholl")
	public Result addScholl(@RequestBody ResumeSchool school) {
		return this.schoolService.add(school);
	}
	@PostMapping("/language/addLanguage")
	public Result addLanguage(@RequestBody ResumeLanguage language) {
		return this.languageService.add(language);
	}
	@PostMapping("/experince/addExperience")
	public Result addExperience(@RequestBody ResumeExperience experience) {
		return this.experienceService.add(experience);
	}
	
	@PostMapping("/uploadphoto")
	public ResponseEntity<?> uploadPhoto(@RequestParam(name = "id") Integer id,
			@RequestParam(name = "filePath") MultipartFile filePath) throws IOException {
		return ResponseEntity.ok(this.resumeService.uploadPhoto(id, filePath));
	}
	
	
	@GetMapping("getResumeDtoByJobSeekerId")
	public DataResult<ResumeDto> getResumeDtoByJobSeekerId(@RequestParam int id){
		return this.resumeService.getResumeDtoByJobSeekerId(id);
	}
	
}
