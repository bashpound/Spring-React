package bashpound.marketplace.security.provider;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import bashpound.marketplace.security.token.AjaxAuthenticationToken;
import bashpound.marketplace.services.MemberDetails;

public class AjaxAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String)authentication.getCredentials();
		
		MemberDetails memberDetails = (MemberDetails)userDetailsService.loadUserByUsername(username);
		
		/*
		 * if(!passwordEncoder.matches(password, memberDetails.getPassword())) { throw
		 * new BadCredentialsException("Invalid Password"); }
		 */
		if(!password.equals(memberDetails.getPassword())) {
			throw new BadCredentialsException("Invalid Password");
		}
		
		return new AjaxAuthenticationToken(memberDetails.getMember(), null, memberDetails.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(AjaxAuthenticationToken.class);
	}

}
