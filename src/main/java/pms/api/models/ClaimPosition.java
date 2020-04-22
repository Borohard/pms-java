package pms.api.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="claim_positions")
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class ClaimPosition extends BaseEntity {
    @Column(name="comment")
    public String comment;

    @Column(name="position_sum")
    public Double sum;

    @ManyToOne
    @JoinColumn(name="claim_id", nullable=false)
    public Claim claim;

    @ManyToOne
    @JoinColumn(name="position_type_id", nullable=false)
    public ClaimPositionType positionType;
}
