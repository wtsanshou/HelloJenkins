package ie.sanshou.aerobics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ie.sanshou.aerobics.model.User;
import lombok.extern.slf4j.XSlf4j;

@Controller
@XSlf4j
@RequestMapping("/user")
public class UserController {
   
    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody User getUsers() {
    	log.info("get all users");
    	User user = User.builder().name("Tao").weight(65.0).height(170.0).age(31).gender(true).build();
    	//TODO: return all users in DB
    	return user;
    }
    
    @RequestMapping(value = "/{name}", method=RequestMethod.GET)
    public @ResponseBody User getUserByName(@PathVariable String name) {
    	log.info("get all users");
    	User user = User.builder().name(name).weight(65.0).height(170.0).age(31).gender(true).build();
    	return user;
    }
	
//  @RequestMapping(value = "/user/", method = RequestMethod.POST)
//  public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
//      log.info("Creating User : {}", user);
////
////      if (userService.isUserExist(user)) {
////          log.error("Unable to create. A User with name {} already exist", user.getName());
////          return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " + 
////          user.getName() + " already exist."),HttpStatus.CONFLICT);
////      }
////      userService.saveUser(user);
//
//      HttpHeaders headers = new HttpHeaders();
//      headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
//      return new ResponseEntity<String>(headers, HttpStatus.CREATED);
//  }
}
