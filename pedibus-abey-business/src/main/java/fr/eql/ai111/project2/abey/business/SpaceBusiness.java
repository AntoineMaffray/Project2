package fr.eql.ai111.project2.abey.business;

import fr.eql.ai111.project2.abey.entity.*;


public interface SpaceBusiness {

    void registerUser (User user);
    void registerChild (Child child);
    void registerSchooling (Schooling schooling);
    void registerSchoolYear (SchoolYear schoolYear);

    Street getStreetUpdatedWithAddresses (Street street);

}
