package fr.eql.ai111.project2.abey.entity;

public class Participation {

    private int participationId;
    private int userId;
    private TypicalDay typicalDayId;
    private  TimeSlot timeSlotId;

    public Participation(int participationId, int userId, TypicalDay typicalDayId, TimeSlot timeSlotId) {
        this.participationId = participationId;
        this.userId = userId;
        this.typicalDayId = typicalDayId;
        this.timeSlotId = timeSlotId;
    }

    public int getParticipationId() {
        return participationId;
    }

    public void setParticipationId(int participationId) {
        this.participationId = participationId;
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
