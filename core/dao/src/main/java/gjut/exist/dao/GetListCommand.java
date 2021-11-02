package gjut.exist.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

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
        List list = null;
        if(order == 1){
            list = session.createCriteria(entityClass).addOrder(Order.asc(column)).list();
        } else {
            list = session.createCriteria(entityClass).addOrder(Order.desc(column)).list();
        }
        return list;
    }
}
