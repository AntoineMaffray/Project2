package fr.eql.ai111.project2.abey.business.impl;

import fr.eql.ai111.project2.abey.business.LoginBusiness;
import fr.eql.ai111.project2.abey.dao.AddressDao;
import fr.eql.ai111.project2.abey.dao.StreetDao;
import fr.eql.ai111.project2.abey.entity.Street;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Remote(LoginBusiness.class)
@Stateless

public class LoginBusinessImpl implements LoginBusiness {

    @EJB
    private StreetDao streetDao;

    @EJB
    private AddressDao addressDao;

    @Override
    public Street getStreetUpdatedWithAddresses(Street street) {
        street.getAddresses().addAll(addressDao.findByStreet(street));
        return street;
    }

    @Override
    public List<Street> findAllStreets() {
        return streetDao.findAllStreets();
    }
}
