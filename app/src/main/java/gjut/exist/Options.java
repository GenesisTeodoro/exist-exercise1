package gjut.exist;

import gjut.exist.dao.HibernateUtil;
import gjut.exist.model.*;
import gjut.exist.service.*;

import java.util.*;

public class Options{

    private PersonManager pm;
    private RoleManager rm;
    private Scanner sc = new Scanner(System.in);
    private Validation v = new Validation();
    public Options(){
        HibernateUtil.createSessionFactory();
        pm = new PersonManagerImpl();
        rm = new RoleManagerImpl();
    }

    public void closeSessionFactory(){
        HibernateUtil.closeSessionFactory();
    }

    public Person getPersonInfo(Person person){
        Name name = new Name();
        Address address = new Address();

        name.setFirstName(v.validString("First Name: "));
        name.setMiddleName(v.validString("Middle Name: "));
        name.setLastName(v.validString("Last Name: "));
        name.setSuffix(v.validString("Suffix: "));
        name.setTitle(v.validString("Title: "));
        person.setName(name);

        person.setBirthday(v.validBirthday());
        person.setEmployeeReference(v.validString("Employee Reference: "));

        address.setUnitNo(v.validString("Unit No: "));
        address.setStreet(v.validString("Street: "));
        address.setBaranggay(v.validString("Baranggay: "));
        address.setSubdivision(v.validString("Subdivision: "));
        address.setMunicipality(v.validString("Municipality: "));
        address.setProvince(v.validString("Province: "));
        address.setZipcode(v.validIntInput("Zipcode: "));
        person.setAddress(address);

        person.setDateHired(v.validDateHired());
        person.setGwa(v.validGwa());
        //person.setCurrentlyEmployed(v.validString("Currently Employed: "));
        return person;
    }

    public Set<Contact> newContact(Set<Contact> set){
        int choice = 1;
        boolean contactExist = false;
        do{
            Contact contact = new Contact();
            String displayOption = "Contact Information: \n"
                    + "[1] Landline Number \n"
                    + "[2] Mobile Number\n"
                    + "[3] Email Address\n"
                    + "Choice: ";
            int numberType = v.validIntOption(displayOption, 1, 4);
            if(numberType == 1){
                contact.setContactType("Landline");
                contact.setContactInfo(v.validContact("Landline"));
            } else if(numberType == 2) {
                contact.setContactType("Mobile");
                contact.setContactInfo(v.validContact("Mobile"));
            } else if(numberType == 3) {
                contact.setContactType("Email");
                contact.setContactInfo(v.validContact("Email"));
            }

            contact.setContactOrder(v.validIntInput("Enter Contact Order: "));

            if(set.isEmpty()){
                set.add(contact);
            } else {
                for(Contact info : set){
                    if(info.getContactInfo().equals(contact.getContactInfo())){
                        System.out.println("Contact already exists");
                        contactExist = true;
                    }
                }
            }
            if(!contactExist){
                set.add(contact);
                System.out.println("Contact added!");
            }
            displayOption = "Add another contact information? \n[1]YES \n[2]No\nChoice: ";
            choice = v.validIntOption(displayOption, 1, 2);
        } while(choice==1);
        return set;
    }

    public void addContactToPerson(){
        System.out.print("Person ID: ");
        long id = sc.nextLong();
        Person person = pm.getPerson(id, "Contacts");
        if(person != null){
            Set<Contact> contactInfo = person.getContacts();
            person.setContacts(newContact(contactInfo));
            pm.updatePerson(person);
        } else {
            System.out.println("Person does not exist..");
        }
    }

    public void displayContacts(String type, Set<Contact> set){
        for(Contact info : set){
            if(!type.equals("")){
                if((info.getContactType()).equals(type)){
                    System.out.println("[" + info.getId() + "] " + info.getContactInfo());
                }
            } else {
                System.out.println("[" + info.getId() + "] " + info.getContactInfo());
            }
        }
    }

    public void displayContactsOfPerson(){
        System.out.print("Person ID: ");
        int id = sc.nextInt();
        Person person = pm.getPerson(id,"Contacts");
        if(person != null){
            Set<Contact> contacts = person.getContacts();
            if(!contacts.isEmpty()){
                System.out.println(person.getName().toString() + " contacts:");
                displayContacts("",contacts);
            } else {
                System.out.println("Person has no contacts!");
            }
        } else{
            System.out.println("Person doesn't exist!");
        }
    }

    public void editContactOfPerson(String type){
        int id = v.validIntInput("Person ID: ");
        Person person = pm.getPerson(id, "Contacts");
        if(person != null){
            Set<Contact> contactInfo = person.getContacts();
            if(!contactInfo.isEmpty()){
                System.out.println(person.getName().toString() + " " + type + " contacts:");
                displayContacts(type, contactInfo);
                int contactIdToEdit = v.validIntInput("Enter Contact Id: ");
                Contact newContact = new Contact();
                Contact oldContact = new Contact();
                for(Contact tempContactInfo : contactInfo){
                    if(tempContactInfo.getId() == contactIdToEdit){
                        oldContact = tempContactInfo;
                        newContact = tempContactInfo;
                    }
                }
                newContact.setContactInfo(v.validContact(newContact.getContactType()));
                contactInfo.remove(oldContact);
                contactInfo.add(newContact);
                person.setContacts(contactInfo);
                System.out.println("Contact updated!");
                pm.updatePerson(person);
            } else {
                System.out.println("Person has no contacts!");
            }
        } else {
            System.out.println("Person does not exist!");
        }
    }

    public void deleteContactOfPerson(){
        int id = v.validIntInput("Person ID: ");
        Person person = pm.getPerson(id, "Contacts");
        boolean check = false;
        if(person != null){
            Set<Contact> contactInfo = person.getContacts();
            if(!contactInfo.isEmpty()){
                displayContacts("",contactInfo);
                int contactIdToDelete = v.validIntInput("Enter Contact Id: ");
                Contact contactToDelete = new Contact();
                for(Contact tempContactInfo : contactInfo){
                    if(tempContactInfo.getId() == contactIdToDelete){
                        contactInfo.remove(tempContactInfo);
                        check = true;
                        break;
                    }
                }
                if(check){
                    person.setContacts(contactInfo);
                    System.out.println("Contact removed!");
                    pm.updatePerson(person);
                } else {
                    System.out.println("Contact doesn't exist!");
                }
            } else {
                System.out.println("Person has no contacts!");
            }
        } else {
            System.out.println("Person doesn't exist!");
        }
    }


    public void addPerson(){
        Person person = getPersonInfo(new Person());
        person.setContacts(newContact(new HashSet<Contact>()));
        //person.setRoles(newRole(new HashSet<Role>()));
        pm.addPerson(person);
    }

    public void updatePerson(){
        int id = v.validIntInput("Person ID: ");
        Person person = pm.getPerson(id, "'");

        if(person!=null){
            pm.updatePerson(getPersonInfo(person));
        }else {
            System.out.println("Person does not exist..");
        }
    }

    public void deletePerson(){
        int id = v.validIntInput("Person ID: ");
        Person person = pm.getPerson(id, "");

        if(person!=null){
            pm.deletePerson(person);
        } else {
            System.out.println("Person does not exist.");
        }
    }

    public void listPersonWithRoles(){
        listRoles();
        int id = v.validIntInput("Role ID: ");

        List<Object[]> list;
        list = pm.listPersonWithRoles(id);
        if(!list.isEmpty()){
            for(Object[] objects : list){
                System.out.println("Person Id: " + (Integer)objects[0]);
                System.out.println("Person Name: " + ((Name)objects[1]).toString());
            }
        } else {
            System.out.println("Role hasn't been associated to person!");
        }
    }

    public void listPerson(int order, String column){
        List list;

        if(column.equals("gwa")){
            list = pm.listPerson(order,"id");
            if(order == 2){
                Collections.sort(list, SortGWA.ascending);
            } else
                Collections.sort(list, SortGWA.descending);
        } else{
            list = pm.listPerson(order,column);
        }

        for(Iterator ir = list.iterator(); ir.hasNext();){
            Person person = (Person)ir.next();
            Set<Contact> contacts = person.getContacts();
            Set<Role> roles = person.getRoles();
            System.out.println("\nPerson ID: " + person.getId());
            System.out.println("Person Name: " + person.getName().toString());
            System.out.println("Person Birthday: " + person.getBirthday().toString());
            System.out.println(".Person Address: " + person.getAddress().toString());
            System.out.println("GWA: " + person.getGwa());
        }
    }

    public Role getRole(){
        int roleId = v.validIntInput("Role Id: ");
        return rm.getRole(roleId);
    }

    public Set<Role> newRole(Set<Role> set){
        int choice;
        boolean roleExist = false;
        do{
            listRoles();
            Role role = getRole();
            if(role!=null){
                if(set.isEmpty()){
                    set.add(role);
                    System.out.println("Role added!");
                } else {
                    for(Role tempRole : set){
                        if(role.getRoleType().equals(tempRole.getRoleType())){
                            System.out.println("Role already exist!");
                            roleExist = true;
                        }
                    }
                    if(!roleExist){
                        set.add(role);
                        System.out.println("oRole added!");
                    }
                }
            } else{
                System.out.println("Role does not exist");
            }
            System.out.print("Add another role?\n[1]Yes\n[2]No\nChoice: ");
            choice = sc.nextInt();
        }while(choice==1);
        return set;
    }

    public void listRoles(){
        ArrayList<Role> list = (ArrayList<Role>)rm.listRoles();
        System.out.println("Roles: ");
        for(Role role: list){
            System.out.println("[" + role.getRoleId() + "] " + role.getRoleType() + "");
        }
    }

    public void addRoleToPerson(){
        int id = v.validIntInput("Person Id: ");
        Person person = pm.getPerson(id, "");

        if(person != null){
            Set<Role> set = person.getRoles();
            person.setRoles(newRole(set));
            pm.updatePerson(person);
        } else {
            System.out.println("Person does not exist.");
        }
    }

    public void listPersonRoles(){
        int id = v.validIntInput("Person ID: ");
        Person person = pm.getPerson(id, "Roles");
        if(person != null){
            Set<Role> personRoles = person.getRoles();
            if(!personRoles.isEmpty()){
                System.out.println(person.getName().toString() + "'s Roles: ");
                for(Role role : personRoles){
                    if(role.getIsActive())
                        System.out.println("[" + role.getRoleId() + "] " + role.getRoleType());
                }
            } else {
                System.out.println("Person has no roles!");
            }
        } else {
            System.out.println("Person does not exist!");
        }
    }

    public void removeRoleFromPerson(){
        int id = v.validIntInput("Person Id: ");
        boolean roleExist = false;
        Person person = pm.getPerson(id,"Roles");
        if(person != null){
            Set<Role> personRoles = person.getRoles();
            if(!personRoles.isEmpty()){
                System.out.println(person.getName().toString() + "'s Roles: ");
                for(Role role : personRoles){
                    System.out.println("[" + role.getRoleId() + "] " + role.getRoleType());
                }
                int roleId = v.validIntInput("Enter Role Id: 	");
                for(Role role : personRoles){
                    if(roleId == role.getRoleId()){
                        personRoles.remove(role);
                        roleExist = true;
                    }
                    if(roleExist){
                        person.setRoles(personRoles);
                        System.out.println("Role removed");
                        pm.updatePerson(person);
                        break;
                    } else {
                        System.out.println("Role doesn't exist..");
                    }
                }
            } else{
                System.out.println("Person doesn't have roles..");
            }
        } else {
            System.out.println("Person doesn't exist..");
        }
    }

    public void updateRoleStatus(){
        listRoles();
        int id = v.validIntInput("Role ID: ");
        Role role = rm.getRole(id);

        if(role != null){
            if(role.getIsActive()){
                System.out.print("Deactive role? [Y/N]: ");
                String choice = sc.next();
                if(choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")){
                    role.setIsActive(false);
                    rm.updateRole(role);
                } else
                    System.out.println("Role deactivation cancelled");
            } else {
                System.out.print("Activate role? [Y/N]: ");
                String choice = sc.next();
                if(choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")){
                    role.setIsActive(true);
                    rm.updateRole(role);
                } else
                    System.out.println("Role activation cancelled");
            }
        } else {
            System.out.println("Role doesn't exist");
        }
    }
}
