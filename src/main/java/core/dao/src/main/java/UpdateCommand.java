import org.hibernate.Session;

public class UpdateCommand<T> implements Command {
    private T t;
    private Session session;

    public UpdateCommand(T t){
        this.t = t;
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public Object execute() {
        session.update(t);
        return Boolean.TRUE;
    }
}
