package fr.eql.ai111.project2.abey.entity;

import java.io.Serializable;

public class RolePrefPart implements Serializable {

    private int role;
    private int day;
    private int timeslot;

    public RolePrefPart(Role role, TypicalDay day, TimeSlot timeslot) {
        this.role = role.ordinal()+1;
        this.day = day.ordinal()+1;
        this.timeslot = timeslot.ordinal()+1;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(int timeslot) {
        this.timeslot = timeslot;
    }
}
