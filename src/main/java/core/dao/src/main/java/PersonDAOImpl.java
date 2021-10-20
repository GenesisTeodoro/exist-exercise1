import org.hibernate.SessionFactory;

import java.util.List;

public class PersonDAOImpl implements PersonDAO {
    private static SessionFactory factory;

    @Override
    public List<Person> getAllPerson() {
        return null;
    }

    @Override
    public Person getPerson(long id) {
        return null;
    }

    @Override
    public void updatePerson(Person person) {

    }

    @Override
    public void deletePerson(Person person) {

    }


}
