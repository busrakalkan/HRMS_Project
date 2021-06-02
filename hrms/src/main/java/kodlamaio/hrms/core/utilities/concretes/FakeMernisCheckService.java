package kodlamaio.hrms.core.utilities.concretes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.utilities.abstracts.MernisCheckService;
import kodlamaio.hrms.entities.concretes.JobSeeker;
@Primary
@Component
public class FakeMernisCheckService implements MernisCheckService{

	@Override
	public boolean checkIfRealPerson(JobSeeker jobSeeker) {
		return true;
	}

}
