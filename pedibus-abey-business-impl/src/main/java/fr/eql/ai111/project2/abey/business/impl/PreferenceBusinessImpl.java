package fr.eql.ai111.project2.abey.business.impl;

import fr.eql.ai111.project2.abey.business.PreferenceBusiness;
import fr.eql.ai111.project2.abey.dao.PreferenceDao;
import fr.eql.ai111.project2.abey.entity.Preference;
import fr.eql.ai111.project2.abey.entity.User;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote (PreferenceBusiness.class)
@Stateless
public class PreferenceBusinessImpl {

    @EJB
    PreferenceDao preferenceDao;



    @Override
    public void superRegisterPreference(Preference preference, User user) {
        preferenceDao.registerPreference(preference, user);
    }
}
