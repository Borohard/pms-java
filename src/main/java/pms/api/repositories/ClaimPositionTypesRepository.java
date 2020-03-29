package pms.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import pms.api.models.ClaimPositionType;

@RestResource(exported = false)
public interface ClaimPositionTypesRepository extends JpaRepository<ClaimPositionType, Long> {
}
