package kodlamaio.hrms.core.utilities.abstracts;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
	
	public boolean emailCheck(String email);
	public boolean emailDomainCheck(String email, String website);
	public String emailSend(String email);
}
