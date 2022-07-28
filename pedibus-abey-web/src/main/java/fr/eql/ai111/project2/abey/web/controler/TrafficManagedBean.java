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
import java.util.List;

@ManagedBean(name = "mbTraffic")
@ViewScoped
public class TrafficManagedBean implements Serializable {

    private List<Line> lines;

    @NotNull(message = "Veuillez renseigner une ligne")
    private Line selectedLine;
    @NotNull(message = "Veuillez renseigner un arrêt")
    private Stop selectedStop;
    @NotNull(message = "Veuillez choisir un nom")
    private String newStopName;
    @NotNull(message = "Veuillez renseigner un arrêt")
    private Address newStopAddress;

    @EJB
    private TrafficBusiness trafficBusiness;

    @PostConstruct
    public void init() {
        lines = findAllLines();
    }

    public Line getLineUpdatedWithStops (Line line) {
        if(line != null) {
            return trafficBusiness.getLineUpdatedWithStops(line);
        }
        return null;
    }

    public void addStop () {
        System.out.println("on rentre dans la méthode");
        Stop stop = new Stop(666, newStopName, newStopAddress.getIdAddress());
        System.out.println("nouvel arrêt créé");
        trafficBusiness.addStopStatement(stop);
        System.out.println("méthode ajout lancée");
    }

    public List<Line> findAllLines () {
        return trafficBusiness.findAllLines();
    }
    public List<Line> getLines() {
        return lines;
    }
    public void setLines(List<Line> lines) {
        this.lines = lines;
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
}
