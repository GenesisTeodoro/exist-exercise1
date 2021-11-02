package gjut.exist.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Person")
public class Person {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Embedded
    private Name name;
    @Embedded
    private Address address;
    @Temporal(TemporalType.DATE)
    @Column(name="birthday")
    private Date birthday;
    @Column(name="gwa")
    private double gwa;
    @Column(name="date_hired")
    private Date dateHired;
    @Column(name="currently_employed")
    private String currentlyEmployed;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="person_id")
    private Set<Contact> contacts;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="person_role", joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
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
