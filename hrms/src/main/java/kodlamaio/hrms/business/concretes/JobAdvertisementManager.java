package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;
@Service


public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İlan başarıyla eklendi!");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getByActivated() {
		return new SuccessDataResult<List<JobAdvertisementDto>>
		(this.jobAdvertisementDao.findByIsActiveTrue(),"Aktif iş ilanları");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getByActivatedOrderByReleaseDateAsc() {
		return new SuccessDataResult<List<JobAdvertisementDto>>
		(this.jobAdvertisementDao.findByIsActiveTrueOrderByReleaseDateAsc(),"Yayın Tarihine göre Aktif ilanlar");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getByActivatedOrderByDeadlineDateAsc() {
		return new SuccessDataResult<List<JobAdvertisementDto>>
		(this.jobAdvertisementDao.findByIsActiveTrueOrderByDeadlineDateAsc(),"Son başvuru tarihine göre aktif ilanlar");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getByActivatedAndEmployer(String companyName) {
		return new SuccessDataResult<List<JobAdvertisementDto>>
		(this.jobAdvertisementDao.findByIsActiveTrueAndEmployer(companyName),"Firmanın aktif iş ilanları");
	}

	@Override
	public Result deactivateJobAdvertisement(Integer id) {
		JobAdvertisement j = this.jobAdvertisementDao.findById(id).get();
		j.setActive(false);
		this.jobAdvertisementDao.save(j);
		return new SuccessResult("İş ilanı kaldırıldı");
	}

	

}
