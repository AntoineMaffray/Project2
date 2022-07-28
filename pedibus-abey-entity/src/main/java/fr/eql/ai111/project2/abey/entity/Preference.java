package fr.eql.ai111.project2.abey.entity;

import java.io.Serializable;

public class Preference implements Serializable {

    private int preferenceId;
    private int userId;
    private TypicalDay typicalDayId;
    private  TimeSlot timeSlotId;

    public Preference(int preferenceId, int userId, TypicalDay typicalDayId, TimeSlot timeSlotId) {
        this.preferenceId = preferenceId;
        this.userId = userId;
        this.typicalDayId = typicalDayId;
        this.timeSlotId = timeSlotId;
    }

    public int getpreferenceId() {
        return preferenceId;
    }

    public void setpreferenceId(int preferenceId) {
        this.preferenceId = preferenceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public TypicalDay getTypicalDayId() {
        return typicalDayId;
    }

    public void setTypicalDayId(TypicalDay typicalDayId) {
        this.typicalDayId = typicalDayId;
    }

    public TimeSlot getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(TimeSlot timeSlotId) {
        this.timeSlotId = timeSlotId;
    }
}
