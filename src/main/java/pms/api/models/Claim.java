package pms.api.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="claims")
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class Claim extends BaseEntity {
    @Column(name="creation_date")
    public Date creationDate;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    public User user;

    @OneToMany(mappedBy = "claim")
    public List<ClaimPosition> claimPositions;
}
