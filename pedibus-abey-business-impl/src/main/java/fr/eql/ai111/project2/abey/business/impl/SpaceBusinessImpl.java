package fr.eql.ai111.project2.abey.business.impl;

import fr.eql.ai111.project2.abey.business.SpaceBusiness;
import fr.eql.ai111.project2.abey.dao.*;
import fr.eql.ai111.project2.abey.entity.*;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.ArrayList;

@Remote(SpaceBusiness.class)
@Stateless
public class SpaceBusinessImpl implements SpaceBusiness {

    @EJB
    UserDao userDao;
    SchoolingDao schoolingDao;
    SchoolYearDao schoolYearDao;
    ChildDao childDao;

   @EJB
    AddressDao addressDao;

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

    @Override
    public Street getStreetUpdatedWithAddresses(Street street) {
        street.setAddresses(new ArrayList<>());
        street.getAddresses().addAll(addressDao.findByStreet(street));
        return street;
    }

}
