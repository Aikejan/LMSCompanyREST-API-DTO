package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean exsistByEmail(String mail);


    Optional<User> getUserById(String email);

    boolean existsByEmail(String email);

    Optional<Object> getUserByEmail(String email);
}
