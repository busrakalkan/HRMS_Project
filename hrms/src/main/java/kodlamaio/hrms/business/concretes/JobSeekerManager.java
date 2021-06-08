package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.validators.abstracts.EmailService;
import kodlamaio.hrms.core.validators.abstracts.MernisCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;


@Service
public class JobSeekerManager implements JobSeekerService {
	private JobSeekerDao jobSeekerDao;
	private EmailService emailService;
	private MernisCheckService mernisCheck;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,EmailService emailService,MernisCheckService mernisCheck) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.emailService = emailService;
		this.mernisCheck = mernisCheck;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>
		(this.jobSeekerDao.findAll(),"İş arayanlar listesi");
	}
	
	@Override 
	public Result login(String email, String password) {
		if(this.jobSeekerDao.getByEmailAndPassword(email,password)!= null){
			return new SuccessResult("Giriş Bararıyla GErçekleştirildi");
		}else {
			return new ErrorResult("Kullanıcı Bulunamadı!");
		}
		 
	}
	@Override
	public Result register(JobSeeker jobSeeker, String passwordRepeat) {
		
		if (!this.mernisCheck.checkIfRealPerson(jobSeeker)) { 
			return new ErrorResult("Girilen bilgiler gerçek bir kişiye ait değil!");
			
		}else if(this.jobSeekerDao.existsJobSeekerByEmail(jobSeeker.getEmail())) {
			return new ErrorResult("Bu email'e sahip bir kayıt mevcuttur.");

		}else if(!jobSeeker.getPassword().equals(passwordRepeat)) {
			return new ErrorResult("Şifre tekrarı yanlış!");
			
		}else if (this.jobSeekerDao.existsJobSeekerByTc(jobSeeker.getTc())) { 
			return new ErrorResult("Bu kimlik numarasına sahip bir kayıt mevcuttur.");
			
		}else {
			this.jobSeekerDao.save(jobSeeker);
			String message = this.emailService.emailSend(jobSeeker.getEmail());
			return new SuccessResult(message + "Başarıyla kayıt olundu!");
		}
			
	}
	  
	@Override 
	public Result delete(JobSeeker jobSeeker) {
		this.jobSeekerDao.delete(jobSeeker); 
		return new SuccessResult("Silme işlemi gerçekleştirildi"); 
	}

	@Override
	public DataResult<JobSeeker> getByJobSeekerId(Integer id) {
		
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findById(id).get(),"id'ye göre iş arayan");
	}


	
}
