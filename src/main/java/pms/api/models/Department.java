package pms.api.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="departments")
@Getter
@Setter
@ToString
public class Department extends BaseEntity {
    @Column(name="department_name")
    public String name;

    @OneToMany(mappedBy = "department")
    public Set<User> users;

    @ManyToOne()
    @JoinColumn(name="responsible_user_id", nullable = true)
    public User responsibleUser;
}
