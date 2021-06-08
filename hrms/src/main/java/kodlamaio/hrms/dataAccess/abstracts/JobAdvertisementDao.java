package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto"
			+ "(e.companyName, p.positionName, c.cityName, j.releaseDate,j.deadlineDate,j.totalOpenPositions)"
			+ "From JobAdvertisement j Inner Join j.employer e Inner Join j.city c "
			+ "Inner Join j.position p where j.isActive=true")	
	List<JobAdvertisementDto> findByIsActiveTrue();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto"
			+ "(e.companyName, p.positionName, c.cityName, j.releaseDate,j.deadlineDate,j.totalOpenPositions)"
			+ "From JobAdvertisement j Inner Join j.employer e Inner Join j.city c "
			+ "Inner Join j.position p where j.isActive=true Order By j.releaseDate ASC")
	List<JobAdvertisementDto> findByIsActiveTrueOrderByReleaseDateAsc();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto"
			+ "(e.companyName, p.positionName, c.cityName, j.releaseDate,j.deadlineDate,j.totalOpenPositions)"
			+ "From JobAdvertisement j Inner Join j.employer e Inner Join j.city c "
			+ "Inner Join j.position p where j.isActive=true Order By j.deadlineDate ASC")
	List<JobAdvertisementDto> findByIsActiveTrueOrderByDeadlineDateAsc();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto"
			+ "(e.companyName, p.positionName, c.cityName, j.releaseDate,j.deadlineDate,j.totalOpenPositions)"
			+ "From JobAdvertisement j Inner Join j.employer e Inner Join j.city c "
			+ "Inner Join j.position p where  j.isActive=true And e.companyName=:companyName")
	List<JobAdvertisementDto> findByIsActiveTrueAndEmployer(String companyName);


	
	
}
