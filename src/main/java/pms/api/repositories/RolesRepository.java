package pms.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pms.api.models.Role;

public interface RolesRepository extends JpaRepository<Role, Long> {
}
