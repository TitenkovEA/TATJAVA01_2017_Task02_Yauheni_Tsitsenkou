package com.epam.at.sportshop.beans;

/**
 * Represents information model about client.
 * Contains clients name, phone number and rented units.
 *
 * @author Eugeny Titenkov
 */
public class Client {
    private String name;
    private String phoneNumber;
    private RentUnit rentUnit;

    public Client(String name, String phoneNumber, RentUnit rentUnit) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.rentUnit = rentUnit;
    }

    public Client(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public RentUnit getRentUnit() {
        if (rentUnit == null) {
            rentUnit = new RentUnit();
        }
        return rentUnit;
    }

    public void setRentUnit(RentUnit rentUnit) {
        this.rentUnit = rentUnit;
    }

    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", rentUnit=" + rentUnit +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Client client = (Client) o;

        return (
                (name != null ? name.equals(client.name) : client.name == null) &&
                (phoneNumber != null ? phoneNumber.equals(client.phoneNumber) : client.phoneNumber == null) &&
                (rentUnit != null ? rentUnit.equals(client.rentUnit) : client.rentUnit == null)
        );
    }

    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (rentUnit != null ? rentUnit.hashCode() : 0);
        return result;
    }
}
