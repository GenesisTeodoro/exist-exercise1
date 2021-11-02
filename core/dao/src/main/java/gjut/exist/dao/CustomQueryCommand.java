package gjut.exist.dao;

import org.hibernate.Session;

import java.util.List;

public class CustomQueryCommand implements Command {
    private Session session;
    private long parameter;

    public CustomQueryCommand(long parameter){
        this.parameter = parameter;
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public Object execute() {
        List list = session.createQuery("select person.id, person.name from Person person INNER JOIN person.roles as proles where proles.role_id = :role_id").
                setParameter("role_id", parameter).list();
        return list;
    }
}
