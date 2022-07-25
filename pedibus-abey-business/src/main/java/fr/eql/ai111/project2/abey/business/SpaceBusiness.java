package fr.eql.ai111.project2.abey.business;

import fr.eql.ai111.project2.abey.entity.Child;
import fr.eql.ai111.project2.abey.entity.SchoolYear;
import fr.eql.ai111.project2.abey.entity.Schooling;
import fr.eql.ai111.project2.abey.entity.User;

public interface SpaceBusiness {

    void registerUser (User user);
    void registerChild (Child child);
    void registerSchooling (Schooling schooling);
    void registerSchoolYear (SchoolYear schoolYear);

}
