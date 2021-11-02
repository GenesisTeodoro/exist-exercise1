package gjut.exist.dao;

import gjut.exist.model.Role;

import java.util.List;
public class RoleDAOImpl implements RoleDAO{

    @Override
    public List listRoles() {
        return HibernateUtil.perform(new GetListCommand(1, "role_id", Role.class), List.class);
    }

    @Override
    public Role getRole(long roleId) {
        return HibernateUtil.perform(new GetCommand(roleId, Role.class, ""), Role.class);
    }

    @Override
    public Boolean updateRole(Role role) {
        return HibernateUtil.perform(new UpdateCommand(role), Boolean.class);
    }
}
