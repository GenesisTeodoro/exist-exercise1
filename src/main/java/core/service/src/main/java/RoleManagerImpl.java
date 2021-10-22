import java.util.List;

public class RoleManagerImpl implements RoleManager{

    private RoleDAO rDAO;

    public RoleManagerImpl(){
        rDAO = new RoleDAOImpl();
    }

    @Override
    public List listRoles() {
        return rDAO.listRoles();
    }

    @Override
    public Role getRole(long roleId) {
        return rDAO.getRole(roleId);
    }

    @Override
    public void updateRole(Role role) {
        rDAO.updateRole(role);
        System.out.println("Role Updated Successfully");
    }
}
