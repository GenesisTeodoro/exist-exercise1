import java.util.List;

public class PersonManagerImpl implements PersonManager{

    private PersonDAO pDAO;

    public PersonManagerImpl(){
        pDAO = new PersonDAOImpl();
    }

    @Override
    public void addPerson(Person person) {
        if(pDAO.addPerson(person))
            System.out.println("Person Added Successfully");
        else
            System.out.println("Person Not Added");
    }

    @Override
    public void updatePerson(Person person) {
        if(pDAO.updatePerson(person))
            System.out.println("Person Updated Successfully");
        else
            System.out.println("Person Not Updated");
    }

    @Override
    public void deletePerson(Person person) {
        if((pDAO.deletePerson(person)).booleanValue())
            System.out.println("Person Deleted Successfully");
        else
            System.out.println("Person Not Deleted");
    }

    @Override
    public Person getPerson(long personId) {
        return pDAO.getPerson(personId);
    }

    @Override
    public List listPerson(int order, String column) {
        return pDAO.listPerson(order, column);
    }

    @Override
    public List listPersonWithRoles(long roleId) {
        return pDAO.listPersonWithRoles(roleId);
    }
}
