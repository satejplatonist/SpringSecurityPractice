package SpringSecurityDemo.com.SpringSecurityDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfig 
{
   @Bean
   public PasswordEncoder passwordEncoder()
   {
	   return NoOpPasswordEncoder.getInstance(); // not to use in production code
   }
}
