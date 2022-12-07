package kodlamaio.northwind.businnes.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.businnes.abstracts.UserService;
import kodlamaio.northwind.core.dataAccess.UserRepository;
import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;


@Service
public class UserManager implements UserService {
	
	private UserRepository userRepository;

	@Autowired
	public UserManager(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public Result add(User user) {
		this.userRepository.save(user);
		return new SuccessResult("Kullanıcı eklendi");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.userRepository.findByEmail(email)
				,"Kullanıcı bulundu");
	}


}
