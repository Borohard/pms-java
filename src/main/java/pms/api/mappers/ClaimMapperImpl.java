package pms.api.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pms.api.dto.ClaimDto;
import pms.api.dto.ClaimPositionDto;
import pms.api.exceptions.NoAccessException;
import pms.api.models.Claim;
import pms.api.models.ClaimPosition;
import pms.api.repositories.ClaimPositionTypesRepository;
import pms.api.repositories.RolesRepository;
import pms.api.services.ClaimsService;
import pms.api.services.ClaimsServiceImpl;
import pms.api.services.UserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClaimMapperImpl implements ClaimMapper {
    private final UserService users;
    private final ClaimsService claims;
    private final ClaimPositionTypesRepository types;

    @Autowired
    public ClaimMapperImpl(UserService users, ClaimsService claims, ClaimPositionTypesRepository types){
        this.claims = claims;
        this.users = users;
        this.types = types;
    }

    @Override
    public ClaimDto toDtoFromClaim(Claim claim){
        ClaimDto res = new ClaimDto();
        res.setId(claim.getId());
        res.setCreationDate(claim.getCreationDate());
        res.setUserId(claim.getUser().getId());
        res.setClaimPositionsDto(claim
                .getClaimPositions()
                .stream()
                .map(this::toDtoFromClaimPosition)
                .collect(Collectors.toList()));

        return res;
    }

    @Override
    public ClaimPositionDto toDtoFromClaimPosition(ClaimPosition position){
        ClaimPositionDto res = new ClaimPositionDto();

        res.setId(position.getId());
        res.setClaimId(position.getClaim().getId());
        res.setClaimPositionTypeId(position.getPositionType().getId());
        res.setClaimPositionTypeName(position.getPositionType().getName());
        res.setComment(position.getComment());
        res.setSum(position.getSum());

        return res;
    }

    @Override
    public Claim toClaimFromDto(ClaimDto claimDto) {
        Claim claim = new Claim();

        claim.setId(claimDto.getId());
        claim.setCreationDate(claimDto.getCreationDate() != null ?
                claimDto.getCreationDate() : convertToDateViaInstant(LocalDate.now()));

        claim.setUser(claimDto.getUserId() != null ?
                users.findById(claimDto.getUserId()) : users.getCurrentUser());

        List<ClaimPosition> list = new ArrayList<>();
        for (ClaimPositionDto claimPositionDto : claimDto
                .getClaimPositionsDto()) {
            ClaimPosition position = toClaimPositionFromDto(claimPositionDto, claim);
            list.add(position);
        }
        claim.setClaimPositions(list);

        return claim;
    }

    @Override
    public ClaimPosition toClaimPositionFromDto(ClaimPositionDto positionDto, Claim parentClaim) {
        ClaimPosition position = new ClaimPosition();
        position.setId(positionDto.getId());
        position.setClaim(parentClaim);

        position.setComment(positionDto.getComment());
        position.setSum(positionDto.getSum());
        position.setPositionType(types.findOne(positionDto.getClaimPositionTypeId()));

        return position;
    }

    private Date convertToDateViaInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }
}
