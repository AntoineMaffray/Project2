package fr.eql.ai111.project2.abey.web.controler;

import fr.eql.ai111.project2.abey.business.TrafficBusiness;
import fr.eql.ai111.project2.abey.entity.Address;
import fr.eql.ai111.project2.abey.entity.Line;
import fr.eql.ai111.project2.abey.entity.Stop;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "mbTraffic")
@ViewScoped
public class TrafficManagedBean implements Serializable {

    private List<Line> lines;
    private List<Stop> stops;
    private  List<Stop> stopsToSave = new ArrayList<>();

    // Line visualising.
    @NotNull(message = "Veuillez renseigner une ligne")
    private Line selectedLine;
    @NotNull(message = "Veuillez renseigner un arrêt")
    private Stop selectedStop;
    @NotNull(message = "Veuillez choisir un nom")
    private String newStopName;
    @NotNull(message = "Veuillez renseigner un arrêt")
    private Address newStopAddress;
    // Line creation.
    @NotNull(message = "Veuillez renseigner une ligne")
    private String newNameLine;

    @EJB
    private TrafficBusiness trafficBusiness;

    @PostConstruct
    public void init() {
        lines = findAllLines();
        stops = findAllStops();
    }


    public Line getLineUpdatedWithStops (Line line) {
        if(line != null) {
            return trafficBusiness.getLineUpdatedWithStops(line);
        }
        return null;
    }

    public String createLine() {
        Line newLine = new Line(0, newNameLine);
        int idLine = trafficBusiness.createLine(newLine);
        trafficBusiness.addStopsToSaveToDb(stopsToSave, newLine, idLine);
        String forward;
        forward = "/popupAddLine.xhtml?faces-redirect=true";
        return forward;
    }

    public void addStopToLine() {
        stopsToSave.add(selectedStop);
    }

    public void moveUp(Stop stop) {
        int newIndex = stopsToSave.indexOf(stop) - 1;
        if (newIndex < 0) {
            newIndex++;
        }
        stopsToSave.remove(stop);
        stopsToSave.add(newIndex,stop);
    }

    public void moveDown(Stop stop) {
        int newIndex = stopsToSave.indexOf(stop) + 1;
        if (newIndex < 0) {
            newIndex--;
        }
        stopsToSave.remove(stop);
        stopsToSave.add(newIndex, stop);
    }

    public List<Line> findAllLines () {
        return trafficBusiness.findAllLines();
    }

    public List<Stop> findAllStops () {
        return trafficBusiness.findAllStops();
    }
    public void addStop () {
        Stop stop = new Stop(666, newStopName, newStopAddress.getIdAddress());
        trafficBusiness.addStopStatement(stop);
        stops = findAllStops();
    }

    public List<Stop> getStopsToSave() {
        return stopsToSave;
    }
    public void setStopsToSave(List<Stop> stopsToSave) {
        this.stopsToSave = stopsToSave;
    }
    public List<Line> getLines() {
        return lines;
    }
    public void setLines(List<Line> lines) {
        this.lines = lines;
    }
    public List<Stop> getStops() {
        return stops;
    }
    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }
    public Line getSelectedLine() {
        return selectedLine;
    }
    public void setSelectedLine(Line selectedLine) {
        this.selectedLine = selectedLine;
    }
    public Stop getSelectedStop() {
        return selectedStop;
    }
    public void setSelectedStop(Stop selectedStop) {
        this.selectedStop = selectedStop;
    }
    public String getNewStopName() {
        return newStopName;
    }
    public void setNewStopName(String newStopName) {
        this.newStopName = newStopName;
    }
    public Address getNewStopAddress() {
        return newStopAddress;
    }
    public void setNewStopAddress(Address newStopAddress) {
        this.newStopAddress = newStopAddress;
    }
    public String getNewNameLine() {
        return newNameLine;
    }
    public void setNewNameLine(String newNameLine) {
        this.newNameLine = newNameLine;
    }

}
