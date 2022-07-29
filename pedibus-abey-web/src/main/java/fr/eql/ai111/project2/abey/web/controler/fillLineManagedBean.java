package fr.eql.ai111.project2.abey.web.controler;

import fr.eql.ai111.project2.abey.business.CreateBusiness;
import fr.eql.ai111.project2.abey.business.TrafficBusiness;
import fr.eql.ai111.project2.abey.entity.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean(name = "mbfillLines")
@ViewScoped
public class fillLineManagedBean implements Serializable {

    List<User> pilotes;

    List<Role> roles;
    List<TypicalDay> typicalDays;
    List<TimeSlot> timeSlots;
    List<Line> lines;

    private User selectedPilote;
    private RolePrefPart selectedRolePrefPart;
    private Line selectedLine;

    @NotNull(message = "veuillez renseigner un rôle")
    private Role newRole;
    @NotNull(message = "veuillez renseigner un jour type")
    private TypicalDay newTypicalDay;
    @NotNull(message = "veuillez renseigner un rôle")
    private TimeSlot newTimeSlot;


    @PostConstruct
    public void init() {
        fillRoles();
        fillTypicalDays();
        fillTimeSlots();
        fillLines();
    }

    @EJB
    private CreateBusiness createBusiness;
    @EJB
    private TrafficBusiness trafficBusiness;

//    @EJB
//    private RolePrefPart rolePrefPart;

    public void fillRoles () {
        roles = Arrays.stream(Role.values()).collect(Collectors.toList());
    }

    public void fillTypicalDays () {
        typicalDays = Arrays.stream(TypicalDay.values()).collect(Collectors.toList());
    }

    public void fillTimeSlots () {
        timeSlots = Arrays.stream(TimeSlot.values()).collect(Collectors.toList());
    }

    public void fillLines () {
        lines = trafficBusiness.findAllLines();
    }

    public void findPilotes () {
        selectedRolePrefPart = new RolePrefPart(newRole, newTypicalDay, newTimeSlot);
        pilotes = createBusiness.findPilotes(selectedRolePrefPart);
    }



    public List<User> getPilotes() {
        return pilotes;
    }

    public void setPilotes(List<User> pilotes) {
        this.pilotes = pilotes;
    }

    public User getSelectedPilote() {
        return selectedPilote;
    }

    public void setSelectedPilote(User selectedPilote) {
        this.selectedPilote = selectedPilote;
    }

    public RolePrefPart getSelectedRolePrefPart() {
        return selectedRolePrefPart;
    }

    public void setSelectedRolePrefPart(RolePrefPart selectedRolePrefPart) {
        this.selectedRolePrefPart = selectedRolePrefPart;
    }

    //    public RolePrefPart getRolePrefPart() {
//        return rolePrefPart;
//    }
//
//    public void setRolePrefPart(RolePrefPart rolePrefPart) {
//        this.rolePrefPart = rolePrefPart;
//    }

    public CreateBusiness getCreateBusiness() {
        return createBusiness;
    }

    public void setCreateBusiness(CreateBusiness createBusiness) {
        this.createBusiness = createBusiness;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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

    public Line getSelectedLine() {
        return selectedLine;
    }

    public void setSelectedLine(Line selectedLine) {
        this.selectedLine = selectedLine;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public TrafficBusiness getTrafficBusiness() {
        return trafficBusiness;
    }

    public void setTrafficBusiness(TrafficBusiness trafficBusiness) {
        this.trafficBusiness = trafficBusiness;
    }

    public void attribuateAccompagnant() {
        createBusiness.attribuateAccompagnant(newTypicalDay, newTimeSlot, selectedPilote, selectedLine);
    }
}
