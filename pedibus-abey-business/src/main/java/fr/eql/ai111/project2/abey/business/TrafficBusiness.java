package fr.eql.ai111.project2.abey.business;

import fr.eql.ai111.project2.abey.entity.Line;
import fr.eql.ai111.project2.abey.entity.Stop;

import java.util.List;

public interface TrafficBusiness {

    Line getLineUpdatedWithStops (Line line);
    List<Line> findAllLines();
    List<Stop> findAllStops();

    int createLine (Line newLine);

    void  addStopsToSaveToDb(List<Stop> stopsToSave, Line newline, int idLigne);
}
