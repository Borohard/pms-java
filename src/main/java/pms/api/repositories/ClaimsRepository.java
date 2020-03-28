package pms.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pms.api.models.Claim;

public interface ClaimsRepository extends JpaRepository<Claim, Long> {
}
