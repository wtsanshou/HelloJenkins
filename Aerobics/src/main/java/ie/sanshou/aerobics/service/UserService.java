package ie.sanshou.aerobics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.sanshou.aerobics.model.User;
import ie.sanshou.aerobics.model.UserRepository;
import lombok.extern.slf4j.XSlf4j;

@XSlf4j
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void save(User user) {
		userRepository.save(user);
		log.info("Save '{}' rows data to database", user.getName());
	}
	
	public User findByName(String name) {
		return userRepository.findOne(name);
	}
	
	public Iterable<User> getAllUser(){
		return userRepository.findAll();
	}
}
