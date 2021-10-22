import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contact {

    @Id
    private long id;
    private String contactType;
    private String contactInfo;

    public Contact(){}

    public Contact(long id, String contactType, String contactInfo){
        this.id = id;
        this.contactType = contactType;
        this.contactInfo = contactInfo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
