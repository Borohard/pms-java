package pms.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pms.api.models.ClaimPositionType;

public interface ClaimPositionTypesRepository extends JpaRepository<ClaimPositionType, Long> {
}
