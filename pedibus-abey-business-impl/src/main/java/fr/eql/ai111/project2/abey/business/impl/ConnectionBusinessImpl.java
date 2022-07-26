package fr.eql.ai111.project2.abey.business.impl;

import fr.eql.ai111.project2.abey.business.ConnectionBusiness;
import fr.eql.ai111.project2.abey.dao.UserDao;
import fr.eql.ai111.project2.abey.entity.User;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(ConnectionBusiness.class)
@Stateless
public class ConnectionBusinessImpl implements ConnectionBusiness {

    @EJB
    private UserDao userDao;

    @Override
    public User authenticate(String login, String password) {
        return userDao.authenticate(login, password);

    }
}
