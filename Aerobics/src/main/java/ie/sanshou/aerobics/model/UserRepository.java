package ie.sanshou.aerobics.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, String>{
	public User findByName(@Param("name") String name);
	public boolean isUserExist(@Param("name") String name);
}
