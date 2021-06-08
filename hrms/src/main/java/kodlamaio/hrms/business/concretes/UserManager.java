package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{
	private UserDao userDao;
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.getByEmail(email),"maile göre sonuçlar");
	}
	
	@Override
	public Result login(String email, String password) {
		
		if(this.userDao.getByEmailAndPassword(email,password)!= null){
			return new SuccessResult("Giriş Bararıyla Grçekleştirildi");
		}else {
			return new ErrorResult("Email veya şifre yanlış!");
		}
	}

	@Override
	public Result add(User user) {
		//this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi");
	}

}
