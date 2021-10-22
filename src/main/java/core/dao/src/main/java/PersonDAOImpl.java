import org.hibernate.SessionFactory;

import java.util.List;

public class PersonDAOImpl implements PersonDAO {
    private static SessionFactory factory;


    @Override
    public Boolean addPerson(Person person) {
        return null;
    }

    @Override
    public Person getPerson(long personID) {
        return null;
    }

    @Override
    public Boolean updatePerson(Person updatedPerson) {
        return null;
    }

    @Override
    public Boolean deletePerson(Person person) {
        return null;
    }

    @Override
    public List listPerson(int order, String column) {
        return null;
    }

    @Override
    public List listPersonWithRoles(long roleId) {
        return null;
    }
}
