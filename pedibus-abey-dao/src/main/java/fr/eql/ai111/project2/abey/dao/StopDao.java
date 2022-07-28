package fr.eql.ai111.project2.abey.dao;

import fr.eql.ai111.project2.abey.entity.Line;
import fr.eql.ai111.project2.abey.entity.Stop;

import java.util.List;

public interface StopDao {

    List<Stop> findByLine (Line line);
}
