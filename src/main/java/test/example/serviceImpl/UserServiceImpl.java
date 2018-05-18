package test.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.example.model.User;
import test.example.repository.UserRepository;
import test.example.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;

	@Override
	public void deleteUserById(long id) {
		userRepository.deleteById(id);;
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public Optional<User> findUserById(long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
}
 