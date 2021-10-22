import java.util.List;

public interface PersonManager {
    void addPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(Person person);
    Person getPerson(long personId);
    List listPerson(int order, String column);
    List listPersonWithRoles(long roleId);
}
