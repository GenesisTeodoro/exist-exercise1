package gjut.exist.service;

import gjut.exist.model.Role;
import java.util.List;

public interface RoleManager {
    List listRoles();
    Role getRole(long roleId);
    void updateRole(Role role);

}
