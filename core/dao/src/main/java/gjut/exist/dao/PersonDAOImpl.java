package gjut.exist.dao;

import gjut.exist.model.Person;
import org.hibernate.SessionFactory;

import java.util.List;

public class PersonDAOImpl implements PersonDAO {
    private static SessionFactory factory;


    @Override
    public Boolean addPerson(Person person) {
        return HibernateUtil.perform(new AddCommand(person), Boolean.class);
    }

    @Override
    public Person getPerson(long personID, String initCollection) {
        return HibernateUtil.perform(new GetCommand(personID, Person.class, initCollection), Person.class);
    }

    @Override
    public Boolean updatePerson(Person updatedPerson) {
        return HibernateUtil.perform(new UpdateCommand(updatedPerson), Boolean.class);
    }

    @Override
    public Boolean deletePerson(Person person) {
        return HibernateUtil.perform(new DeleteCommand(person), Boolean.class);
    }

    @Override
    public List listPerson(int order, String column) {
        return HibernateUtil.perform(new GetListCommand(order, column, Person.class), List.class);
    }

    @Override
    public List listPersonWithRoles(long roleId) {
        return HibernateUtil.perform(new CustomQueryCommand(roleId), List.class);
    }
}
