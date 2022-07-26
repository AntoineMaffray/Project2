package fr.eql.ai111.project2.abey.business;

import fr.eql.ai111.project2.abey.entity.Child;
import fr.eql.ai111.project2.abey.entity.SchoolYear;
import fr.eql.ai111.project2.abey.entity.Schooling;
import fr.eql.ai111.project2.abey.entity.User;

public interface SpaceBusiness {

    void registerUser (User user);

    void registerChild(Child child, User user);

    void superRegisterChild(Child child, Schooling schooling, User user);

    void registerSchooling(Schooling schooling, User user);

    void registerSchoolYear (SchoolYear schoolYear);

}
