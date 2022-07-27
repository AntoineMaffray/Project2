package fr.eql.ai111.project2.abey.entity;

import java.util.Date;

public class Participation {

    private int idParticipation;
    private Date dateRequest;
    private Date dateAttribution;
    private Date dateTermination;
    private int user1;
    private Role roleId;

    public Participation(int idParticipation, Date dateRequest, Date dateAttribution, Date dateTermination, int user1, Role roleId) {
        this.idParticipation = idParticipation;
        this.dateRequest = dateRequest;
        this.dateAttribution = dateAttribution;
        this.dateTermination = dateTermination;
        this.user1 = user1;
        this.roleId = roleId;
    }

    public int getIdParticipation() {
        return idParticipation;
    }

    public void setIdParticipation(int idParticipation) {
        this.idParticipation = idParticipation;
    }

    public Date getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(Date dateRequest) {
        this.dateRequest = dateRequest;
    }

    public Date getDateAttribution() {
        return dateAttribution;
    }

    public void setDateAttribution(Date dateAttribution) {
        this.dateAttribution = dateAttribution;
    }

    public Date getDateTermination() {
        return dateTermination;
    }

    public void setDateTermination(Date dateTermination) {
        this.dateTermination = dateTermination;
    }

    public int getUser1() {
        return user1;
    }

    public void setUser1(int user1) {
        this.user1 = user1;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }
}
