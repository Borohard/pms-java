package pms.api.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="claim_position_types")
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false, of={"name"})
public class ClaimPositionType extends BaseEntity {
    @Column(name="type_name")
    public String name;

    @OneToMany(mappedBy = "positionType")
    public Set<ClaimPosition> claimPositions;
}
