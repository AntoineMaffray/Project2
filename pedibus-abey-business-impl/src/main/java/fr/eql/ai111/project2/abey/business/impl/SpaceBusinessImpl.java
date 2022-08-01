package fr.eql.ai111.project2.abey.business.impl;

import fr.eql.ai111.project2.abey.business.SpaceBusiness;
import fr.eql.ai111.project2.abey.dao.*;
import fr.eql.ai111.project2.abey.entity.*;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Remote(SpaceBusiness.class)
@Stateless
@Transactional
public class SpaceBusinessImpl implements SpaceBusiness {

    @EJB
    UserDao userDao;

    @EJB
    SchoolingDao schoolingDao;

    @EJB
    SchoolYearDao schoolYearDao;

    @EJB
    ChildDao childDao;

   @EJB
   AddressDao addressDao;

    @Override
    public void registerUser(User user) {
        userDao.registerUser(user);
    }


    @Override
    public void superRegisterChild(Child child, Schooling schooling, User user) {
        int childId = childDao.registerChild(child, user);
        schoolingDao.registerSchooling(schooling, user, childId);
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

    @Override
    public void findChildren(User user) {
        userDao.findChildren(user);
    }

}
