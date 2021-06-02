package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	List<JobAdvertisement> findByIsActiveTrue();
	List<JobAdvertisement> findByIsActiveTrueOrderByReleaseDateAsc();
	List<JobAdvertisement> findByIsActiveTrueOrderByDeadlineDateAsc();
	
	//@Query("From JobAdvertisement where isActive=:true and employer.id=:id")
	List<JobAdvertisement> findByIsActiveTrueAndEmployer_Id(int id);
	
	
}
