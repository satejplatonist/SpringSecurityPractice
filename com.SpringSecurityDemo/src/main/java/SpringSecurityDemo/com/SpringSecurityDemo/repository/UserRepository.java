package SpringSecurityDemo.com.SpringSecurityDemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import SpringSecurityDemo.com.SpringSecurityDemo.models.User;

public interface UserRepository extends JpaRepository<User,Long>
{
	@Query("SELECT u FROM User u WHERE u.name = :name")
    Optional<User> findUserByUserName(String name);

}
