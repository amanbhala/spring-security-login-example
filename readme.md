Architecture of the application.
@ManyToMany:
cascade=CascadeType.ALL -> Whenever parent entity will perform operations like Persist,Merge,Remove,Refresh then it is also applicable to it's children.
fetch=FetchType.EAGER -> User class will eagerly try to get all the roles associated with the user.

- Whenever springboot find thymeleaf dependency in the classpath, springboot will automatically configure view Resolver for thymeleaf template engine.
- @EnableWebSecurity - Will integrate spring security with spring mvc. It will also enable web security support.
- UserDetails is returned by the UserDetailsService. The DaoAuthenticationProvider validates the UserDetails and then returns an Authentication that has a principal that is the UserDetails returned by the configured UserDetailsService.
- DaoAuthenticationProvider is an AuthenticationProvider implementation that uses a UserDetailsService and PasswordEncoder to authenticate a username and password.