import org.hibernate.Session;
import org.hibernate.criterion.Order;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class GetListCommand<T> implements Command {
    private Session session;
    private String column;
    private int order;
    private Class<T> entityClass;

    public GetListCommand(int order, String column, Class<T> entityClass){
        this.column = column;
        this.order = order;
        this.entityClass = entityClass;
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public Object execute() {
        return null;
    }
}
