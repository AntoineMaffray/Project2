package fr.eql.ai111.project2.abey.business;

import fr.eql.ai111.project2.abey.entity.*;


public interface SpaceBusiness {

    void registerUser (User user);

    void superRegisterChild(Child child, Schooling schooling, User user);

    void registerSchoolYear (SchoolYear schoolYear);

    Street getStreetUpdatedWithAddresses (Street street);

    void findChildren(User user);

}
