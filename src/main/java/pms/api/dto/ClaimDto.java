package pms.api.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ClaimDto {
    public Long id;
    public Date creationDate;
    public Long userId;
    public List<ClaimPositionDto> claimPositionsDto;
}
