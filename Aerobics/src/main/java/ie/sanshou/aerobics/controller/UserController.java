package ie.sanshou.aerobics.controller;

import java.net.URI;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ie.sanshou.aerobics.model.User;
import ie.sanshou.aerobics.service.UserService;
import lombok.extern.slf4j.XSlf4j;

@Controller
@XSlf4j
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody Iterator<User> getUsers() {
		log.info("get all users");
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public @ResponseBody User getUserByName(@PathVariable String name) {
		log.info("get the user '{}'", name);
		User user = userService.findByName(name);
		return user;
	}
	
	@PostMapping()
	public ResponseEntity<Void> saveAUser(@RequestBody User newUser) {
		User user = userService.save(newUser);

		if (user == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}").buildAndExpand(user.getName())
				.toUri();
		log.info("saved a user '{}'", user.getName());
		return ResponseEntity.created(location).build();
	}

}
