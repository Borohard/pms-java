package pms.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import pms.api.models.User;

@RestResource(exported = false)
public interface UsersRepository extends JpaRepository<User, Long> {
}
