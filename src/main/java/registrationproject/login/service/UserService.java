package registrationproject.login.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import registrationproject.login.model.User;
import registrationproject.login.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
}
