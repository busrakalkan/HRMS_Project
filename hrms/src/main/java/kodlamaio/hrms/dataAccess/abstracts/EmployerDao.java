package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	
	boolean existsEmployerByEmail(String email); // uniqe mail kontrolü için
	Employer getByEmailAndPassword(String email,String password); //login için


}
