package fr.eql.ai111.project2.abey.business;

import fr.eql.ai111.project2.abey.entity.Street;

import java.util.List;

public interface LoginBusiness {

    Street getStreetUpdatedWithAddresses (Street street);
    List<Street> findAllStreets();
}
