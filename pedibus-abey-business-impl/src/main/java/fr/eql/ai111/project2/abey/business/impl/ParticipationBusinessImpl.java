package fr.eql.ai111.project2.abey.business.impl;

import fr.eql.ai111.project2.abey.business.ParticipationBusiness;
import fr.eql.ai111.project2.abey.dao.ParticipationDAO;
import fr.eql.ai111.project2.abey.dao.StreetDao;

import javax.ejb.EJB;

public class ParticipationBusinessImpl implements ParticipationBusiness {

    @EJB
    private ParticipationDAO participationDAO;

}
