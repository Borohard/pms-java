package pms.api.mappers;

import pms.api.dto.ClaimDto;
import pms.api.dto.ClaimPositionDto;
import pms.api.exceptions.NoAccessException;
import pms.api.models.Claim;
import pms.api.models.ClaimPosition;

public interface ClaimMapper {
    ClaimDto toDtoFromClaim(Claim claim);

    ClaimPositionDto toDtoFromClaimPosition(ClaimPosition position);

    Claim toClaimFromDto(ClaimDto claimDto);

    ClaimPosition toClaimPositionFromDto(ClaimPositionDto positionDto,  Claim parentClaim);
}
