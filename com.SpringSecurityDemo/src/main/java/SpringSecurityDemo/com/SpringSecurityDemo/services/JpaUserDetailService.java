package SpringSecurityDemo.com.SpringSecurityDemo.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import SpringSecurityDemo.com.SpringSecurityDemo.models.User;
import SpringSecurityDemo.com.SpringSecurityDemo.repository.UserRepository;
import SpringSecurityDemo.com.SpringSecurityDemo.security.SecurityUser;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class JpaUserDetailService implements UserDetailsService
{
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username)
	{
		Optional<User> user = userRepository.findUserByUserName(username);
		
		return user.map(SecurityUser::new)
		           .orElseThrow(()-> new UsernameNotFoundException(username + " not found"));
	}
}
