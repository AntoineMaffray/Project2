package fr.eql.ai111.project2.abey.dao;

import fr.eql.ai111.project2.abey.entity.Child;
import fr.eql.ai111.project2.abey.entity.User;

public interface ChildDao {

    void registerChild(Child child, User user);
}
