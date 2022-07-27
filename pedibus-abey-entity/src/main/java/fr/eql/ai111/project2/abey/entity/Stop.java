package fr.eql.ai111.project2.abey.entity;

import java.io.Serializable;

public class Stop implements Serializable {

    private int idStop;
    private String nameStop;
    private int addressIdStop;

    public Stop(int idStop, String nameStop, int addressIdStop) {
        this.idStop = idStop;
        this.nameStop = nameStop;
        this.addressIdStop = addressIdStop;
    }

    public int getIdStop() {
        return idStop;
    }
    public void setIdStop(int idStop) {
        this.idStop = idStop;
    }
    public String getNameStop() {
        return nameStop;
    }
    public void setNameStop(String nameStop) {
        this.nameStop = nameStop;
    }
    public int getAddressIdStop() {
        return addressIdStop;
    }
    public void setAddressIdStop(int addressIdStop) {
        this.addressIdStop = addressIdStop;
    }
}
