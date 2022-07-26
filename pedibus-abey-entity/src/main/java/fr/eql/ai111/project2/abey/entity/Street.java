package fr.eql.ai111.project2.abey.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Street implements Serializable {

    private int idStreet;
    private String nameStreet;
    private List<Address> streetNumbers = new ArrayList<>();

    public Street(int idStreet, String nameStreet) {
        this.idStreet = idStreet;
        this.nameStreet = nameStreet;
    }

    public int getIdStreet() {
        return idStreet;
    }
    public void setIdStreet(int idStreet) {
        this.idStreet = idStreet;
    }
    public String getNameStreet() {
        return nameStreet;
    }
    public void setNameStreet(String nameStreet) {
        this.nameStreet = nameStreet;
    }
    public List<Address> getStreetNumbers() {
        return streetNumbers;
    }
    public void setStreetNumbers(List<Address> streetNumbers) {
        this.streetNumbers = streetNumbers;
    }
}
