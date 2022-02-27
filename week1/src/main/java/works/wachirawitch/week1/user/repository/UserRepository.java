package works.wachirawitch.week1.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import works.wachirawitch.week1.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByEmail(String email);
}
