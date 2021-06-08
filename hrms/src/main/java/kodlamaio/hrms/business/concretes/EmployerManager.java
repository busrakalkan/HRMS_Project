package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.PersonnelService;
import kodlamaio.hrms.core.validators.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;


@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private EmailService emailService;
	private PersonnelService personnelService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailService emailService, PersonnelService personnelService) {
		super();
		this.employerDao = employerDao;
		this.emailService = emailService;
		this.personnelService = personnelService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş veren listesi");
	}

	@Override
	public Result login(String email, String password) {
		
		if(this.employerDao.getByEmailAndPassword(email,password)!= null){
			return new SuccessResult("Giriş Bararıyla Grçekleştirildi");
		}else {
			return new ErrorResult("Email veya şifre yanlış!");
		}
	}

	@Override
	public Result register(Employer employer, String passwordRepeat) {
		
		if(!this.emailService.emailDomainCheck(employer.getEmail(), employer.getWebAddress())) {
			return new ErrorResult("Email ve web adresi aynı domainde olmalıdır!");
			
		}else if(this.employerDao.existsEmployerByEmail(employer.getEmail())) {
			return new ErrorResult("Bu email'e sahip bir kayıt mevcuttur.");
			
		}else if(!employer.getPassword().equals(passwordRepeat)) {
			return new ErrorResult("Şifre tekrarı yanlış!");
			
		}else if(!this.personnelService.registerPermit(employer)) {
			return new ErrorResult("Sistem personeli henüz kaydı onaylamadı!");
			
		}else {
			this.employerDao.save(employer);
			String message = this.emailService.emailSend(employer.getEmail());
			return new SuccessResult(message + "Başarıyla kayıt olundu!");
		}
		
	}

	@Override
	public Result delete(Employer employer) {
		this.employerDao.delete(employer);
		return null;
	}


}
