package SpringSecurityDemo.com.SpringSecurityDemo.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController 
{
   @GetMapping(value = "/home")
   public String Home()
   {
	   var u = SecurityContextHolder.getContext().getAuthentication();
	   u.getAuthorities().forEach(s->System.out.println(s));
	   return "Welcome to Spring Security Demo";
   }
}
