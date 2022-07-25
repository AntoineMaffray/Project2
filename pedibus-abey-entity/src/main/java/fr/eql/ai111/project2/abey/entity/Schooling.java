package fr.eql.ai111.project2.abey.entity;

import java.io.Serializable;

public class Schooling implements Serializable {
    private int idSchooling;
    private int idSchool;
    private int idSchoolYear;
    private int idSchoolLevel;
    private int idChild;

    public Schooling(int idSchooling, int idSchool, int idSchoolYear, int idSchoolLevel, int idChild) {
        this.idSchooling = idSchooling;
        this.idSchool = idSchool;
        this.idSchoolYear = idSchoolYear;
        this.idSchoolLevel = idSchoolLevel;
        this.idChild = idChild;
    }

    public int getIdSchooling() {
        return idSchooling;
    }

    public void setIdSchooling(int idSchooling) {
        this.idSchooling = idSchooling;
    }

    public int getIdSchool() {
        return idSchool;
    }

    public void setIdSchool(int idSchool) {
        this.idSchool = idSchool;
    }

    public int getIdSchoolYear() {
        return idSchoolYear;
    }

    public void setIdSchoolYear(int idSchoolYear) {
        this.idSchoolYear = idSchoolYear;
    }

    public int getIdChild() {
        return idChild;
    }

    public void setIdChild(int idChild) {
        this.idChild = idChild;
    }

    public int getIdSchoolLevel() {
        return idSchoolLevel;
    }

    public void setIdSchoolLevel(int idSchoolLevel) {
        this.idSchoolLevel = idSchoolLevel;
    }
}
