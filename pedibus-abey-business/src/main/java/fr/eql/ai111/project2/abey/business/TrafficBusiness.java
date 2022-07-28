package fr.eql.ai111.project2.abey.business;

import fr.eql.ai111.project2.abey.entity.Address;
import fr.eql.ai111.project2.abey.entity.Line;
import fr.eql.ai111.project2.abey.entity.Stop;
import fr.eql.ai111.project2.abey.entity.Stop;
import fr.eql.ai111.project2.abey.entity.Street;

import java.util.List;

public interface TrafficBusiness {

    Line getLineUpdatedWithStops (Line line);
    List<Line> findAllLines();
    List<Stop> findAllStops();

    int createLine (Line newLine);
    void addStopStatement (Stop stop);

    void  addStopsToSaveToDb(List<Stop> stopsToSave, Line newline, int idLigne);
}
