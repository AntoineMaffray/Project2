package fr.eql.ai111.project2.abey.business;

import fr.eql.ai111.project2.abey.entity.Line;

import java.util.List;

public interface TrafficBusiness {

    Line getLineUpdatedWithStops (Line line);
    List<Line> findAllLines();


}
