package gjut.exist.dao;

import gjut.exist.model.Person;
import java.util.List;

public interface PersonDAO {

    Boolean addPerson(Person person);
    Person getPerson(long personID, String initCollection);
    Boolean updatePerson(Person updatedPerson);
    Boolean deletePerson(Person person);
    List listPerson(int order, String column);
    List listPersonWithRoles(long roleId);
}
