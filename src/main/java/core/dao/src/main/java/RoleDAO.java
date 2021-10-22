import java.util.List;

public interface RoleDAO {
    List listRoles();
    Role getRole(long roleId);
    Boolean updateRole(Role role);
}
