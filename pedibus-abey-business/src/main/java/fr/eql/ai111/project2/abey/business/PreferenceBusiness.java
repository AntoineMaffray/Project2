package fr.eql.ai111.project2.abey.business;

import fr.eql.ai111.project2.abey.entity.Participation;
import fr.eql.ai111.project2.abey.entity.Preference;
import fr.eql.ai111.project2.abey.entity.User;

public interface PreferenceBusiness {

    void RegisterPreference(Preference preference, User user);

    void RegisterParticipation(Participation participation, User user);
}
