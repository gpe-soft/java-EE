package nl.gpesoft.javaee.persistence.common;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PERSON")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "personType", discriminatorType=DiscriminatorType.STRING, length = 30)
public abstract class PersonTable extends CommonFields {

    private String title;
    private String initials;
    private String surname;
    private String emailAddress;
    private Date dateOfBirth;
    private long socialSecurityNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="addressId")
    private AddressTable residentialAddress;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(long socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public AddressTable getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(AddressTable residentialAddress) {
        this.residentialAddress = residentialAddress;
    }
}