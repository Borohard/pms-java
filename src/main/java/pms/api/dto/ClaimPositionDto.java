package pms.api.dto;

import lombok.Data;

@Data
public class ClaimPositionDto {
    public Long id;
    public Long claimId;
    public Double sum;
    public Long claimPositionTypeId;
    public String claimPositionTypeName;
    public String comment;
}
