package fr.eql.ai111.project2.abey.dao;

import fr.eql.ai111.project2.abey.entity.Preference;
import fr.eql.ai111.project2.abey.entity.Schooling;
import fr.eql.ai111.project2.abey.entity.User;

public interface PreferenceDao {

    void registerPreference(Preference preference, User user);

}
