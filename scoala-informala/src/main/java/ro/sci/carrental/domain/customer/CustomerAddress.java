package ro.sci.carrental.domain.customer;

/**
 * Initialize customer addresses.
 * @author flaviu.lupoian
 */
public class CustomerAddress {
    private String streetAddress;
    private String city;

    public CustomerAddress() {
    }

    public CustomerAddress(String streetAddress, String city) {
        this.streetAddress = streetAddress;
        this.city = city;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return streetAddress + "," + city;
    }
}