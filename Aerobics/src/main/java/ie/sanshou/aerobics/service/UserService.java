package ie.sanshou.aerobics.service;

import java.util.Iterator;

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

	public User save(User user) {
		if (isUserExist(user)) {
			log.debug("user '{}' is already exist", user.getName());
			return user;
		}
		userRepository.save(user);
		log.info("Save '{}' to database", user.getName());
		return user;
	}

	public User findByName(String name) {
		return userRepository.findByName(name);
	}

	public Iterator<User> getAllUsers() {
		return userRepository.findAll().iterator();
	}

	private boolean isUserExist(User user) {
		return userRepository.findByName(user.getName()) != null;
	}
}
