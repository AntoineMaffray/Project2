package fr.eql.ai111.project2.abey.dao;

import fr.eql.ai111.project2.abey.entity.Participation;
import fr.eql.ai111.project2.abey.entity.Schooling;
import fr.eql.ai111.project2.abey.entity.User;

public interface ParticipationDAO {
    void registerParticipation(Participation participation, User user);

}
