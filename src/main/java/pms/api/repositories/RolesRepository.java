package pms.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import pms.api.models.Role;

@RestResource(exported = false)
public interface RolesRepository extends JpaRepository<Role, Long> {
}
