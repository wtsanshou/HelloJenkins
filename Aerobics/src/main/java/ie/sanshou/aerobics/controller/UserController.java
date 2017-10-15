package ie.sanshou.aerobics.controller;

public class UserController {

	
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
