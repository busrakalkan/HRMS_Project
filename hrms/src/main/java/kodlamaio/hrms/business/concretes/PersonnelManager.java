package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PersonnelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PersonnelDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.Personnel;



@Service
public class PersonnelManager implements PersonnelService{
	
	private PersonnelDao personnelDao;
	
	@Autowired
	public PersonnelManager(PersonnelDao personnelDao) {
		super();
		this.personnelDao = personnelDao;
	}

	@Override
	public DataResult<List<Personnel>> getAll() {
		return new SuccessDataResult<List<Personnel>>(this.personnelDao.findAll(),"Personeller listelendi");
	}
	
	@Override
	public Result add(Personnel personnel) {
		this.personnelDao.save(personnel);
		return new SuccessResult("Personel eklendi");
	}
	@Override
	public Result getById(int id) {
		return new SuccessDataResult<Personnel>(this.personnelDao.findById(id).get(),
				"Belirtilen sistem çalışanı başarıyla bulundu.");
	}

	@Override
	public boolean registerPermit(Employer employer) {
		//Employer register permit
		return true;
	}

	@Override
	public Result login(String email, String password) {
		if(this.personnelDao.getByEmailAndPassword(email,password)!= null){
			return new SuccessResult("Giriş Bararıyla GErçekleştirildi");
		}else {
			return new ErrorResult("Kullanıcı Bulunamadı!");
		}
	}


}
