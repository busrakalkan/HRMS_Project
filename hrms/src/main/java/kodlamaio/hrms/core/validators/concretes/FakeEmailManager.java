package kodlamaio.hrms.core.validators.concretes;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.validators.abstracts.EmailService;
@Component
public class FakeEmailManager implements EmailService{
	
	private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
	@Override
	public boolean emailCheck(String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(email).find();
	}

	@Override
	public String emailSend(String email) {
		return email + " adresine doğrulama linki gönderildi.";
		
	}

	@Override
	public boolean emailDomainCheck(String email, String website) {
		// fake email domain regex check 
		return true;
	}

}
