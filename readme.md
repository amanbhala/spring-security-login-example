Architecture of the application.
- @ManyToMany:
 - cascade=CascadeType.ALL -> Whenever parent entity will perform operations like Persist,Merge,Remove,Refresh then it is also applicable to it's children.
 - fetch=FetchType.EAGER -> User class will eagerly try to get all the roles associated with the user.

- Whenever springboot find thymeleaf dependency in the classpath, springboot will automatically configure view Resolver for thymeleaf template engine.
- @EnableWebSecurity - Will integrate spring security with spring mvc. It will also enable web security support.
- UserDetails is returned by the UserDetailsService. The DaoAuthenticationProvider validates the UserDetails and then returns an Authentication that has a principal that is the UserDetails returned by the configured UserDetailsService. Read more [here](https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/dao-authentication-provider.html)
- DaoAuthenticationProvider is an AuthenticationProvider implementation that uses a UserDetailsService and PasswordEncoder to authenticate a username and password.
Authentication object is present in the SecurityContextHolder and it contains the expected user details. An exaple of `authentication` object is:
```
Authentication object: UsernamePasswordAuthenticationToken [Principal=org.springframework.security.core.userdetails.User [Username=a, Password=[PROTECTED], Enabled=true, AccountNonExpired=true, credentialsNonExpired=true, AccountNonLocked=true, Granted Authorities=[ROLE_USER]], Credentials=[PROTECTED], Authenticated=true, Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=75803EF3E11B70026DF8B4D9F58C6721], Granted Authorities=[ROLE_USER]]
```
- UserDetails is an interface from Spring Security used to hold non-security-related user information. The framework's UserDetailsService single method interface is responsible for fetching the UserDetails during the authentication process.
User class implements UserDetails interface. The DaoAuthenticationProvider authenticates a username and password.
- Read more on spring security authentication [here](ahttps://docs.spring.io/spring-security/reference/servlet/authentication/passwords/in-memory.html) and [here](https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/form.html).
- Some useful articles [this](https://spring.io/guides/gs/securing-web/) , [this](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#web.security) , [this](https://www.codejava.net/frameworks/spring-boot/fix-websecurityconfigureradapter-deprecated) and [this](https://www.baeldung.com/spring-thymeleaf-user-info).