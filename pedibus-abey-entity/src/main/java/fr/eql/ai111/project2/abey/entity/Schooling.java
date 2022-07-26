package fr.eql.ai111.project2.abey.entity;

import java.io.Serializable;

public class Schooling implements Serializable {
    private int idSchooling;
    private School idSchool;
    private SchoolLevel idSchoolLevel;
    private int idChild;

    public Schooling(int idSchooling, School idSchool, SchoolLevel idSchoolLevel, int idChild) {
        this.idSchooling = idSchooling;
        this.idSchool = idSchool;
        this.idSchoolLevel = idSchoolLevel;
        this.idChild = idChild;
    }

    public int getIdSchooling() {
        return idSchooling;
    }

    public void setIdSchooling(int idSchooling) {
        this.idSchooling = idSchooling;
    }

    public School getIdSchool() {
        return idSchool;
    }

    public void setIdSchool(School idSchool) {
        this.idSchool = idSchool;
    }

    public SchoolLevel getIdSchoolLevel() {
        return idSchoolLevel;
    }

    public void setIdSchoolLevel(SchoolLevel idSchoolLevel) {
        this.idSchoolLevel = idSchoolLevel;
    }

    public int getIdChild() {
        return idChild;
    }

    public void setIdChild(int idChild) {
        this.idChild = idChild;
    }
}
