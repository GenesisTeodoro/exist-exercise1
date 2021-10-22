import java.util.List;

public interface RoleManager {
    List listRoles();
    Role getRole(long roleId);
    void updateRole(Role role);

}
