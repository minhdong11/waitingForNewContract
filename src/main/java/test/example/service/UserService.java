package test.example.service;

import java.util.List;
import java.util.Optional;

import test.example.model.User;

public interface UserService {
	void deleteUserById(long id);
	User save(User user);
	Optional<User> findUserById(long id);
	List<User> getAllUser();
}
