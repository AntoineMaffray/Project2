package fr.eql.ai111.project2.abey.dao;

import fr.eql.ai111.project2.abey.entity.City;
import fr.eql.ai111.project2.abey.entity.Street;

import java.util.List;

public interface StreetDao {

    List<Street> findByCity (City city);

}
