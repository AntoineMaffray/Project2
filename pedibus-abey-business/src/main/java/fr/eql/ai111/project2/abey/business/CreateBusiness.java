package fr.eql.ai111.project2.abey.business;

import fr.eql.ai111.project2.abey.entity.*;

import java.util.List;

public interface CreateBusiness {

    List<User> findPilotes (RolePrefPart rolePrefPart);

    void attribuateAccompagnant(TypicalDay newTypicalDay, TimeSlot newTimeSlot, User selectedPilote, Line selectedLine);
}
