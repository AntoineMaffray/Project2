package fr.eql.ai111.project2.abey.dao;

import fr.eql.ai111.project2.abey.entity.User;

import java.sql.Connection;
import java.sql.Date;

public interface UserDao {

    /*
    void registerUser (
            String login,
            String password,
            String name,
            String firstname,
            Date birthDate,
            String phone,
            String mail,
            Date dateCreationAccount);*/

    void registerUser (User user);

}
