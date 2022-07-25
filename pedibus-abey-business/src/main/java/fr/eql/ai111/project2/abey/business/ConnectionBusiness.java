package fr.eql.ai111.project2.abey.business;

import fr.eql.ai111.project2.abey.entity.User;

public interface ConnectionBusiness {

    User authenticate(String login, String password);
}
