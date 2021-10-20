import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
public class Person {

    @Id
    private long id;
    private String name;
    private String address;
    private Date birthday;
    private double gwa;
    private Date dateHired;
    private String currentlyEmployed;
    private int landlineNumber;
    private int mobileNumber;
    private String email;
    //private List roles;

    public Person(){}

    public Person(long id, String name, String address,
                  Date birthday, double gwa, Date dateHired,
                  String currentlyEmployed, int landlineNumber,
                  int mobileNumber, String email){
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthday = birthday;
        this.gwa = gwa;
        this.dateHired = dateHired;
        this.currentlyEmployed = currentlyEmployed;
        this.landlineNumber = landlineNumber;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
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

    public int getLandlineNumber() {
        return landlineNumber;
    }

    public void setLandlineNumber(int landlineNumber) {
        this.landlineNumber = landlineNumber;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public List getRoles() {
//        return roles;
//    }
//
//    public void setRole(Role role) {
//        this.roles.add(role);
//    }
}
