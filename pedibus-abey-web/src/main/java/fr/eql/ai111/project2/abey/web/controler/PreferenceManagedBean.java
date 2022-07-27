package fr.eql.ai111.project2.abey.web.controler;

import fr.eql.ai111.project2.abey.business.PreferenceBusiness;
import fr.eql.ai111.project2.abey.entity.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean(name = "mbpreference")
@ViewScoped
public class PreferenceManagedBean implements Serializable {

    @ManagedProperty(value = "#{mbConnection.connectedUser}")
    private User connectedUser;

    private List<TypicalDay> typicalDays = new ArrayList<>();
    private List<TimeSlot> timeSlots= new ArrayList<>();

    @NotNull(message = "veuillez choisir un jour")
    private String newTypicalDay;
    @NotNull (message = "veuillez choisir un créneau")
    private String newTimeSlot;

    @EJB
    private PreferenceBusiness preferenceBusiness;

    public void fillTypicalDays () {
        typicalDays = Arrays.stream(TypicalDay.values()).collect(Collectors.toList());
    }

    public void fillTimeSlot () {
        timeSlots = Arrays.stream(TimeSlot.values()).collect(Collectors.toList());
    }

    public User getConnectedUser() {
        return connectedUser;
    }

    public void setConnectedUser(User connectedUser) {
        this.connectedUser = connectedUser;
    }

    public List<TypicalDay> getTypicalDays() {
        return typicalDays;
    }

    public void setTypicalDays(List<TypicalDay> typicalDays) {
        this.typicalDays = typicalDays;
    }

    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }

    public String getNewTypicalDay() {
        return newTypicalDay;
    }

    public void setNewTypicalDay(String newTypicalDay) {
        this.newTypicalDay = newTypicalDay;
    }

    public String getNewTimeSlot() {
        return newTimeSlot;
    }

    public void setNewTimeSlot(String newTimeSlot) {
        this.newTimeSlot = newTimeSlot;
    }

    public PreferenceBusiness getPreferenceBusiness() {
        return preferenceBusiness;
    }

    public void setPreferenceBusiness(PreferenceBusiness preferenceBusiness) {
        this.preferenceBusiness = preferenceBusiness;
    }
}
