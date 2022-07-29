package fr.eql.ai111.project2.abey.dao;

import fr.eql.ai111.project2.abey.entity.Line;
import fr.eql.ai111.project2.abey.entity.Stop;

import java.util.List;

public interface LineDao {

    List<Line> findAllLines ();
    int createLine (Line newLine);
    void  addStopsToSaveToDb(List<Stop> stopsToSave, Line newLine, int idLine);
}
