import java.util.List;

public interface PersonDAO {

    Boolean addPerson(Person person);
    Person getPerson(long personID);
    Boolean updatePerson(Person updatedPerson);
    Boolean deletePerson(Person person);
    List listPerson(int order, String column);
    List listPersonWithRoles(long roleId);
}
