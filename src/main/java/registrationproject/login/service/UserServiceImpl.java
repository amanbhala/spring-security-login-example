package registrationproject.login.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import registrationproject.login.model.Role;
import registrationproject.login.model.User;
import registrationproject.login.repository.UserRepository;
import registrationproject.login.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFirstName(),registrationDto.getLastName(),
                    registrationDto.getEmail(),passwordEncoder.encode(registrationDto.getPassword()),
                    Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }

    // We are converting roles into authorities. We are converting roles into SimpleGrantedAuthority object which is spring security provided class and we pass role name to the class and finally converted stream into list and returned it.
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user==null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        // We are getting the user object stored. Provides core user information. In this function we are retrieving the User data stored by spring security using email and password.
        // We are passing email and password and roles as null.
        // https://docs.spring.io/spring-security/site/docs/6.0.2/api/org/springframework/security/core/userdetails/UserDetails.html
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }
    
}
