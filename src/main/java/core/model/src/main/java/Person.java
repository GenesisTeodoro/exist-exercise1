import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@Entity
public class Person {

    @Id
    private long id;
    private Name name;
    private Address address;
    private Date birthday;
    private double gwa;
    private Date dateHired;
    private String currentlyEmployed;

    @OneToMany
    private Set<Contact> contacts;

    @OneToMany
    private Set<Role> roles;

    public Person(){}

    public Person(long id, Name name, Address address,
                  Date birthday, double gwa, Date dateHired,
                  String currentlyEmployed, Set<Contact> contacts,
                  Set<Role> roles){
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthday = birthday;
        this.gwa = gwa;
        this.dateHired = dateHired;
        this.currentlyEmployed = currentlyEmployed;
        this.contacts = contacts;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getGwa() {
        return gwa;
    }

    public void setGwa(double gwa) {
        this.gwa = gwa;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    public String getCurrentlyEmployed() {
        return currentlyEmployed;
    }

    public void setCurrentlyEmployed(String currentlyEmployed) {
        this.currentlyEmployed = currentlyEmployed;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
