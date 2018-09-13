package dataaccess;

import java.io.Serializable;

public class Person implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
    private String lastName;
    private String phoneNumber;
    private Address address;

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
    	return firstName + " " + lastName
    		 + "\nPhone Number: " + phoneNumber
    		 + "\nAddress:\n" + address.toString(); 
    }
}
