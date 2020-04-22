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
@Table(name="roles")
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false, of={"name"})
public class Role extends BaseEntity {
    @Column(name="role_name")
    public String name;

    @OneToMany(mappedBy = "role")
    public Set<User> users;
}
