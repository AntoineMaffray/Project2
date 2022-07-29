package fr.eql.ai111.project2.abey.dao;

import fr.eql.ai111.project2.abey.entity.User;

import java.sql.Connection;
import java.sql.Date;

public interface UserDao {

    User authenticate(String login, String password);

    void registerUser (User user);

    void findChildren(User user);
}
