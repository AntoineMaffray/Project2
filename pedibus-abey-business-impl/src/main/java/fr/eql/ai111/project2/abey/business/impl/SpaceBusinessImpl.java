package fr.eql.ai111.project2.abey.business.impl;

import fr.eql.ai111.project2.abey.business.SpaceBusiness;
import fr.eql.ai111.project2.abey.dao.UserDao;
import fr.eql.ai111.project2.abey.entity.User;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(SpaceBusiness.class)
@Stateless
public class SpaceBusinessImpl implements SpaceBusiness {

    @EJB
    UserDao userDao;

    @Override
    public void registerUser(User user) {
        userDao.registerUser(user);
    }
}
