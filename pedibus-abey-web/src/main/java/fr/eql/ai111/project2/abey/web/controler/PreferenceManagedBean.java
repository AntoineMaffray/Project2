package fr.eql.ai111.project2.abey.web.controler;

import fr.eql.ai111.project2.abey.business.PreferenceBusiness;
import fr.eql.ai111.project2.abey.entity.*;

import javax.annotation.PostConstruct;
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
    private List<Role> roles = new ArrayList<>();

    @NotNull(message = "veuillez choisir un rôle")
    private Role newRole;
    @NotNull(message = "veuillez choisir un jour")
    private TypicalDay newTypicalDay;
    @NotNull (message = "veuillez choisir un créneau")
    private TimeSlot newTimeSlot;

    @EJB
    private PreferenceBusiness preferenceBusiness;

    @PostConstruct
    public void init() {
        fillRoles();
        fillTypicalDays();
        fillTimeSlots();
    }

    public void registerPreference () {
        Preference preference = new Preference(666, 666, newTypicalDay, newTimeSlot);
        preferenceBusiness.RegisterPreference(preference, connectedUser);
    }

    public  void  registerParticipation () {
        Participation participation = new Participation(666,666, newRole);
        preferenceBusiness.RegisterParticipation(participation, connectedUser);
    }

    public void fillTypicalDays () {
        typicalDays = Arrays.stream(TypicalDay.values()).collect(Collectors.toList());
    }

    public void fillTimeSlots () {
        timeSlots = Arrays.stream(TimeSlot.values()).collect(Collectors.toList());
    }

    public void fillRoles () {
        roles = Arrays.stream(Role.values()).collect(Collectors.toList());
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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

    public PreferenceBusiness getPreferenceBusiness() {
        return preferenceBusiness;
    }

    public void setPreferenceBusiness(PreferenceBusiness preferenceBusiness) {
        this.preferenceBusiness = preferenceBusiness;
    }

    public Role getNewRole() {
        return newRole;
    }

    public void setNewRole(Role newRole) {
        this.newRole = newRole;
    }

    public TypicalDay getNewTypicalDay() {
        return newTypicalDay;
    }

    public void setNewTypicalDay(TypicalDay newTypicalDay) {
        this.newTypicalDay = newTypicalDay;
    }

    public TimeSlot getNewTimeSlot() {
        return newTimeSlot;
    }

    public void setNewTimeSlot(TimeSlot newTimeSlot) {
        this.newTimeSlot = newTimeSlot;
    }
}
