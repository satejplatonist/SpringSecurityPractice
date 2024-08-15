package SpringSecurityDemo.com.SpringSecurityDemo.security;

import org.springframework.security.core.GrantedAuthority;

import SpringSecurityDemo.com.SpringSecurityDemo.models.Authorities;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority
{
	private final Authorities authority;
	
	@Override
	public String getAuthority() 
	{
		return authority.getAuthorityName();
	}
}
