package fr.eql.ai111.project2.abey.entity;

import java.io.Serializable;

public class Address implements Serializable {

    private int idAddress;
    private String streetNumber;

    public Address(int idAddress, String streetNumber) {
        this.idAddress = idAddress;
        this.streetNumber = streetNumber;
    }

    public int getIdAddress() {
        return idAddress;
    }
    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }
    public String getStreetNumber() {
        return streetNumber;
    }
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
