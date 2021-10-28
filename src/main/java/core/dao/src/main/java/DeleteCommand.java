import org.hibernate.Session;

public class DeleteCommand<T> implements Command {
    private T t;
    private Session session;

    private DeleteCommand(T t){
        this.t = t;
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public Object execute() {
        session.delete(t);
        return Boolean.TRUE;
    }
}
