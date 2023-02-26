package registrationproject.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import registrationproject.login.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String username);
}
