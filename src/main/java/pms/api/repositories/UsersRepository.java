package pms.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pms.api.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
