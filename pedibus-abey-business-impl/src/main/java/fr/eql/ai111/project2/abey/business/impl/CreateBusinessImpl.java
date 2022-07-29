package fr.eql.ai111.project2.abey.business.impl;

import fr.eql.ai111.project2.abey.business.CreateBusiness;
import fr.eql.ai111.project2.abey.dao.CreateDao;
import fr.eql.ai111.project2.abey.entity.*;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;


@Remote(CreateBusiness.class)
@Stateless
public class CreateBusinessImpl implements CreateBusiness {

    @EJB
    CreateDao createDao;

    @Override
    public List<User> findPilotes (RolePrefPart rolePrefPart) {
        return createDao.findPilotes(rolePrefPart);
    }

    @Override
    public void attribuateAccompagnant(TypicalDay newTypicalDay, TimeSlot newTimeSlot, User selectedPilote, Line selectedLine) {
        createDao.attribuateAccompagnant(newTypicalDay, newTimeSlot, selectedPilote, selectedLine);
    }


}
