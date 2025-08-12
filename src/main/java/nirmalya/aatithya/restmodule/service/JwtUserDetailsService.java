package nirmalya.aatithya.restmodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import nirmalya.aatithya.restmodule.user.dao.UserLoginDao;
import nirmalya.aatithya.restmodule.user.model.User;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UserLoginDao userLoginDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = null;
		System.out.println("username " + username);
		try {
			user = userLoginDao.loadUserByName(username);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if (user.getUserMobile().equals(username) || user.getUser().equals(username) || user.getUserEmail().equals(username)) {
			System.out.println("CustomUserDetailsService====" + user);
			return new CustomUserDetails(user);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}	
 	
}
