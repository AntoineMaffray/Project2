package fr.eql.ai111.project2.abey.dao;

import fr.eql.ai111.project2.abey.entity.Child;
import fr.eql.ai111.project2.abey.entity.Schooling;
import fr.eql.ai111.project2.abey.entity.User;

public interface SchoolingDao {

    void registerSchooling(Schooling schooling, User user, int childId);
}
