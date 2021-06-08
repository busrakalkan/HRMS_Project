package kodlamaio.hrms.business.concretes;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.imageUpload.CloudinaryUploadService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.dataAccess.abstracts.cvInfo.ExperienceDao;
import kodlamaio.hrms.dataAccess.abstracts.cvInfo.LanguageDao;
import kodlamaio.hrms.dataAccess.abstracts.cvInfo.SchollDao;
import kodlamaio.hrms.dataAccess.abstracts.cvInfo.SkillsDao;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeDto;

@Service
public class ResumeManager implements ResumeService{
	
	private ResumeDao resumeDao;
	private SchollDao schoolDao;
	private ExperienceDao experDao;
	private SkillsDao skillsDao;
	private LanguageDao languageDao;
	
	private CloudinaryUploadService cloudinaryUploadService;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao,SchollDao schoolDao, ExperienceDao experDao,SkillsDao skillsDao,LanguageDao languageDao, CloudinaryUploadService cloudinaryUploadService) {
		super();
		this.resumeDao = resumeDao;
		this.schoolDao =schoolDao;
		this.experDao = experDao;
		this.skillsDao = skillsDao;
		this.languageDao = languageDao;
		this.cloudinaryUploadService = cloudinaryUploadService;
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(),"Tüm Öz geçmişlerin listesi");
	}

	@Override
	public Result add(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult("Öz geçmiş başarıyla eklendi");
	}

	@Override
	public DataResult<Resume> getByJobSeekerId(int id) {
		return new SuccessDataResult<Resume>(this.resumeDao.getByJobSeekerId(id),id+" idli adayın öz geçmişi");
	}
	

	@Override
	public DataResult<ResumeDto> getResumeDtoByJobSeekerId(int id) {
		//kullanıcının resume bilgileri
		Resume js=this.resumeDao.getByJobSeekerId(id);
		// resume bilgilerinin istenilen formata çevrilmesi
		ResumeDto resume = new ResumeDto();
		resume.setName(js.getJobSeeker().getFirstName());
		resume.setSurname(js.getJobSeeker().getLastName());
		resume.setCoverLetter(js.getCoverLetter());
		resume.setGithubLink(js.getGithubLink());
		resume.setLinkedinLink(js.getLinkedinLink());
		resume.setSchools(this.schoolDao.getSchoolsOrderByEndedDateDesc(js.getId()));
		resume.setExperiences(this.experDao.getExperiencesOrderByEndedDateDesc(js.getId()));
		resume.setLanguages(this.languageDao.getLanguages(js.getId()));
		resume.setSkills(this.skillsDao.getSkills(js.getId()));
		return new SuccessDataResult<ResumeDto>(resume);
	}

	@Override
	public DataResult<String> uploadPhoto(Integer id, MultipartFile filePath) throws IOException {
		BufferedImage bi = ImageIO.read(filePath.getInputStream());
		//File file = new File(filePath);
		Object object = this.cloudinaryUploadService.upload(filePath).get("secure_url");
		
		if ((bi == null)) {
			return new ErrorDataResult<String>("Failed to load photo! Not found image.", null);
			
		} else if (!this.resumeDao.existsById(id)) {
			return new ErrorDataResult<String>("Failed to load photo! Not found resume.", null);
			
		} else {
			String secure_url = object.toString();
			Resume r = this.resumeDao.findById(id).get();
			r.setPhotoLink(secure_url);
			this.resumeDao.save(r);
			return new SuccessDataResult<String>("Photo upload successfully.", secure_url);
		}
	}
}