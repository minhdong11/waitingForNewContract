package test.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.example.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
