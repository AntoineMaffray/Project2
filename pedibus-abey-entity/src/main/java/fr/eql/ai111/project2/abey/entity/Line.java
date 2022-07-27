package fr.eql.ai111.project2.abey.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Line implements Serializable {

    private int idLine;
    private String nameLine;
    private Date dateCreationLine;
    private Date dateEndLine;
    private List<Stop> stops = new ArrayList<>();

    public Line(int idLine, String nameLine, Date dateCreationLine, Date dateEndLine) {
        this.idLine = idLine;
        this.nameLine = nameLine;
        this.dateCreationLine = dateCreationLine;
        this.dateEndLine = dateEndLine;
    }

    public int getIdLine() {
        return idLine;
    }
    public void setIdLine(int idLine) {
        this.idLine = idLine;
    }
    public String getNameLine() {
        return nameLine;
    }
    public void setNameLine(String nameLine) {
        this.nameLine = nameLine;
    }
    public Date getDateCreationLine() {
        return dateCreationLine;
    }
    public void setDateCreationLine(Date dateCreationLine) {
        this.dateCreationLine = dateCreationLine;
    }
    public Date getDateEndLine() {
        return dateEndLine;
    }
    public void setDateEndLine(Date dateEndLine) {
        this.dateEndLine = dateEndLine;
    }
    public List<Stop> getStops() {
        return stops;
    }
    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }
}
