package fr.koor.webstore.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table(name = "T_UserInformations")
public class UserInformations {

    @Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int     idInformations;
    
    private String  address;
    
    private String  city;
    
    private String  email;
    
    private String  phoneNumber;
    
    @OneToOne
    @JoinColumn( name="idUser", nullable=false )
//    @JoinTable( name = "T_Users_Informations_Associations",
//			    joinColumns = @JoinColumn( name = "idUserInformations" ),
//			    inverseJoinColumns = @JoinColumn( name = "idUser" ) )
    private User user;

    
    public UserInformations() {
        this( "unknown", "unknown", "unknown", "unknown" );
    }
    
    public UserInformations( String address, String city, String email, String phoneNumber ) {
        this.setAddress( address );
        this.setCity( city );
        this.setEmail( email );
        this.setPhoneNumber( phoneNumber );
    }
    
    public int getIdInformations() {
        return idInformations;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public User getUser() {
		return user;
	}

    public void setUser(User user) {
		this.user = user;
	}
    
    @Override
    public String toString() {
        return "\tidInformations=" + idInformations + "\n\taddress=" + address 
             + "\n\tcity=" + city + "\n\temail=" + email + "\n\tphoneNumber=" + phoneNumber + "\n";
    }
    
}