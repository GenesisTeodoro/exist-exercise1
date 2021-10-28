import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Roles")
public class Role {

    @Id
    @Column(name = "role_id")
    private long roleId;
    @Column(name = "role_type")
    private String roleType;
    @Column(name = "isActive", nullable = false)
    private boolean isActive = true;

    @ManyToMany(mappedBy="roles", fetch=FetchType.EAGER)
    private Set<Person> persons;

    public Role() {}

    public Role(long roleId, String roleType,
                boolean isActive, Set<Person> persons) {
        this.roleId = roleId;
        this.roleType = roleType;
        this.isActive = isActive;
        this.persons = persons;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}
