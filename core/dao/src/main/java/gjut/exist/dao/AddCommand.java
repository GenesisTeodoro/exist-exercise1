package gjut.exist.dao;

import org.hibernate.Session;

public class AddCommand<T> implements Command {

    private T t;
    private Session session;

    public AddCommand(T t){
        this.t = t;
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public Object execute() {
        session.save(t);
        return Boolean.TRUE;
    }
}
