package fr.eql.ai111.project2.abey.business.impl;

import fr.eql.ai111.project2.abey.business.PreferenceBusiness;
import fr.eql.ai111.project2.abey.dao.ParticipationDAO;
import fr.eql.ai111.project2.abey.dao.PreferenceDao;
import fr.eql.ai111.project2.abey.entity.Participation;
import fr.eql.ai111.project2.abey.entity.Preference;
import fr.eql.ai111.project2.abey.entity.User;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote (PreferenceBusiness.class)
@Stateless
public class PreferenceBusinessImpl implements PreferenceBusiness {

    @EJB
    private PreferenceDao preferenceDao;

    @EJB
    private ParticipationDAO participationDAO;


    @Override
    public void RegisterPreference(Preference preference, User user) {
        preferenceDao.registerPreference(preference, user);
    }

    @Override
    public void RegisterParticipation (Participation participation , User user) {
        participationDAO.registerParticipation(participation, user);
    }


}
