package fr.eql.ai111.project2.abey.business.impl;

import fr.eql.ai111.project2.abey.business.SpaceBusiness;
import fr.eql.ai111.project2.abey.dao.ChildDao;
import fr.eql.ai111.project2.abey.dao.SchoolYearDao;
import fr.eql.ai111.project2.abey.dao.SchoolingDao;
import fr.eql.ai111.project2.abey.dao.UserDao;
import fr.eql.ai111.project2.abey.entity.Child;
import fr.eql.ai111.project2.abey.entity.SchoolYear;
import fr.eql.ai111.project2.abey.entity.Schooling;
import fr.eql.ai111.project2.abey.entity.User;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(SpaceBusiness.class)
@Stateless
public class SpaceBusinessImpl implements SpaceBusiness {

    @EJB
    UserDao userDao;
    SchoolingDao schoolingDao;
    SchoolYearDao schoolYearDao;
    ChildDao childDao;

    @Override
    public void registerUser(User user) {
        userDao.registerUser(user);
    }

    @Override
    public void registerChild(Child child) {
        childDao.registerChild(child);
    }

    @Override
    public void registerSchooling(Schooling schooling) {
        schoolingDao.registerschooling(schooling);
    }

    @Override
    public void registerSchoolYear(SchoolYear schoolYear) {
        schoolYearDao.registerSchoolYear(schoolYear);
    }

}
