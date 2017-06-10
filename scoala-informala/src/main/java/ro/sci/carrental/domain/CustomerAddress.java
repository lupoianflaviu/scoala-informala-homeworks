package ro.sci.carrental.domain;

/**
 * Initialize customer addresses.
 */
public class CustomerAddress {
    private String streetAddress;
    private String city;
    private String county;
    private String country;
    private String postalCode;

    /**
     * Default Constructor
     */
    public CustomerAddress() {}

    /**
     * Constructor for all fields
     * @param streetAddress Street address of customer
     * @param city City
     * @param county County
     * @param country Country
     * @param postalCode Postal Code
     */
    public CustomerAddress(String streetAddress, String city, String county, String country, String postalCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.county = county;
        this.country = country;
        this.postalCode = postalCode;
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

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}