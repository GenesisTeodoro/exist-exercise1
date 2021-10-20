import java.util.List;

public interface PersonDAO {

    public List<Person> getAllPerson();
    public Person getPerson(long id);
    public void updatePerson(Person person);
    public void deletePerson(Person person);
}
