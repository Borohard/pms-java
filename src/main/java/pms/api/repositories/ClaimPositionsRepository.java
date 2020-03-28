package pms.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pms.api.models.ClaimPosition;

public interface ClaimPositionsRepository extends JpaRepository<ClaimPosition, Long> {
}
