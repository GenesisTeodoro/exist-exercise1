package gjut.exist.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    public Class<T> getEntityClass(){
        return entityClass;
    }

    public String getColumn(){
        return column;
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public Object execute() {
        List list = null;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(getEntityClass());
        Root root = criteria.from(getEntityClass());
        criteria.select(root);


        if(order == 1){
            list = criteria.orderBy(builder.asc(root.get(column))).getOrderList();

            //deprecated
            //list = session.createCriteria(entityClass).addOrder(Order.asc(column)).list();
        } else {

            list = criteria.orderBy(builder.desc(root.get(column))).getOrderList();

            //deprecated
            //list = session.createCriteria(entityClass).addOrder(Order.desc(column)).list();
        }
        return list;
    }
}
