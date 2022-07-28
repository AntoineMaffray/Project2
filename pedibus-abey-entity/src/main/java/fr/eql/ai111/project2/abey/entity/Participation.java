package fr.eql.ai111.project2.abey.entity;


import java.io.Serializable;

public class Participation implements Serializable {

    private int idParticipation;
    private int user1;
    private Role roleId;

    public Participation(int idParticipation, int user1, Role roleId) {
        this.idParticipation = idParticipation;
        this.user1 = user1;
        this.roleId = roleId;
    }

    public int getIdParticipation() {
        return idParticipation;
    }

    public void setIdParticipation(int idParticipation) {
        this.idParticipation = idParticipation;
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
