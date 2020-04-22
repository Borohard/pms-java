package pms.api.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false, of={"login"})
public class User extends BaseEntity {
    @Column(name="login")
    public String login;

    @Column(name="password")
    public String password;

    @Column(name="full_name")
    public String fullName;

    @OneToMany(mappedBy = "user")
    public Set<Claim> claims;

    @ManyToOne
    @JoinColumn(name = "role_id",nullable = false)
    public Role role;

    @ManyToOne
    @JoinColumn(name = "department_id",nullable = true)
    public Department department;

    @OneToMany(mappedBy = "responsibleUser")
    public Set<Department> departments;
}
