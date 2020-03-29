package pms.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import pms.api.models.ClaimPosition;

@RestResource(exported = false)
public interface ClaimPositionsRepository extends JpaRepository<ClaimPosition, Long> {
}
