package fr.eql.ai111.project2.abey.dao;


import fr.eql.ai111.project2.abey.entity.*;

import java.util.List;

public interface CreateDao {

    List<User> findPilotes (RolePrefPart rolePrefPart);

    void attribuateAccompagnant(TypicalDay newTypicalDay, TimeSlot newTimeSlot, User selectedPilote, Line selectedLine);
}
