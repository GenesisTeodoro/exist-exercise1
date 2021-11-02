package gjut.exist.dao;

import gjut.exist.model.Person;
import org.hibernate.Session;

public class GetCommand<T> implements Command {
    private Session session;
    private Long id;
    private Class<T> entityClass;
    private String initCollection;

    public GetCommand(Long id, Class<T> entityClass, String initCollection){
        this.id = id;
        this.entityClass = entityClass;
        this.initCollection = initCollection;
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public Object execute() {
        Object obj = session.get(entityClass, id);
        if(obj instanceof Person){
            Person person = (Person)obj;
            if(initCollection.contains("Contacts"))
                person.getContacts().size();
            if(initCollection.contains("Roles"))
                person.getRoles().size();
            obj = person;
        }
        return obj;
    }
}
