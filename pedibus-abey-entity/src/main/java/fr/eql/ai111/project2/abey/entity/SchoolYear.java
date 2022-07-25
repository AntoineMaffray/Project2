package fr.eql.ai111.project2.abey.entity;

import java.io.Serializable;
import java.util.Date;

public class SchoolYear implements Serializable {

private int idSchoolYear;
private Date dateStartSchoolYear;
private Date dateEndSchoolYear;

    public SchoolYear(int idSchoolYear, Date dateStartSchoolYear, Date dateEndSchoolYear) {
        this.idSchoolYear = idSchoolYear;
        this.dateStartSchoolYear = dateStartSchoolYear;
        this.dateEndSchoolYear = dateEndSchoolYear;
    }

    public int getIdSchoolYear() {
        return idSchoolYear;
    }

    public void setIdSchoolYear(int idSchoolYear) {
        this.idSchoolYear = idSchoolYear;
    }

    public Date getDateStartSchoolYear() {
        return dateStartSchoolYear;
    }

    public void setDateStartSchoolYear(Date dateStartSchoolYear) {
        this.dateStartSchoolYear = dateStartSchoolYear;
    }

    public Date getDateEndSchoolYear() {
        return dateEndSchoolYear;
    }

    public void setDateEndSchoolYear(Date dateEndSchoolYear) {
        this.dateEndSchoolYear = dateEndSchoolYear;
    }
}
