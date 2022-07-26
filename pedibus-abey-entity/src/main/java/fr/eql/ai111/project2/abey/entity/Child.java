package fr.eql.ai111.project2.abey.entity;

import java.io.Serializable;
import java.util.Date;

public class Child implements Serializable {

    private int idChild;
    private String firstnameChild;
    private String nameChild;
    private Date birthDateChild;
    private int schoolYear;
    private int user1;
    private int user2;

    public Child(int idChild, String firstnameChild, String nameChild, Date birthDateChild, int schoolYear, int user1, int user2) {
        this.idChild = idChild;
        this.firstnameChild = firstnameChild;
        this.nameChild = nameChild;
        this.birthDateChild = birthDateChild;
        this.schoolYear = schoolYear;
        this.user1 = user1;
        this.user2 = user2;
    }

    public int getIdChild() {
        return idChild;
    }

    public void setIdChild(int idChild) {
        this.idChild = idChild;
    }

    public String getFirstnameChild() {
        return firstnameChild;
    }

    public void setFirstnameChild(String firstnameChild) {
        this.firstnameChild = firstnameChild;
    }

    public String getNameChild() {
        return nameChild;
    }

    public void setNameChild(String nameChild) {
        this.nameChild = nameChild;
    }

    public Date getBirthDateChild() {
        return birthDateChild;
    }

    public void setBirthDateChild(Date birthDateChild) {
        this.birthDateChild = birthDateChild;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    public int getUser1() {
        return user1;
    }

    public void setUser1(int user1) {
        this.user1 = user1;
    }

    public int getUser2() {
        return user2;
    }

    public void setUser2(int user2) {
        this.user2 = user2;
    }


}
