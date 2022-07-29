package fr.eql.ai111.project2.abey.dao.impl;

import fr.eql.ai111.project2.abey.dao.CreateDao;
import fr.eql.ai111.project2.abey.dao.impl.connection.PedibusAbeyDataSource;
import fr.eql.ai111.project2.abey.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Remote(CreateDao.class)
@Stateless
public class CreateDaoImpl implements CreateDao {

    private static final Logger logger = LogManager.getLogger();
    private final DataSource dataSource = new PedibusAbeyDataSource();

    private static final String REQ_FIND_PARTIPANTS_BY_PREFERENCE = "SELECT u.id_user, u.name_user, u.firstname_user " +
            "FROM user u, participation pa, preference pr " +
            "WHERE pa.role_id = ? AND pr.timeslot_id = ? AND pr. typical_day_id = ? " +
            "AND u.id_user = pa.user_id AND u.id_user = pr.user_id " +
            "ORDER BY name_user";

    private static final String REQ_ATTRIBUATE =
            "insert into attribution (user_id, " +
                    "line_id, " +
                    "typical_day_id, " +
                    "timeslot_id) " +
                    "values (?, ?, ?, ?)" +
                    ";";

    @Override
    public List<User> findPilotes(RolePrefPart rolePrefPart) {
        List<User> pilotes = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(REQ_FIND_PARTIPANTS_BY_PREFERENCE);
            statement.setInt(1, rolePrefPart.getRole());
            statement.setInt(2, rolePrefPart.getTimeslot());
            statement.setInt(3, rolePrefPart.getDay());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                pilotes.add(new User(resultSet.getInt("id_user"),
                        resultSet.getString("name_user"),
                        resultSet.getString("firstname_user")));
            }
            connection.close();
        } catch (SQLException e) {
            logger.error("Une erreur c'est produite lors de la consultation des pilotes de ligne en base de données.", e);
        }
        return pilotes;
    }


    @Override
    public void attribuateAccompagnant (TypicalDay newTypicalDay, TimeSlot newTimeSlot, User selectedPilote, Line selectedLine) {

        try (Connection connection = dataSource.getConnection()){
            connection.setAutoCommit(false);
            addStopStatementExecution(newTypicalDay, newTimeSlot, selectedPilote, selectedLine, connection);
            connection.commit();
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de l'écriture " +
                    "de l'arrêt en base de données", e);
        }
    }

    private void addStopStatementExecution (TypicalDay newTypicalDay, TimeSlot newTimeSlot, User selectedPilote, Line selectedLine, Connection connection) throws SQLException {
        int id = 0;
        PreparedStatement statement = connection.prepareStatement(REQ_ATTRIBUATE, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, selectedPilote.getIdUser());
        statement.setInt(2, selectedLine.getIdLine());
        statement.setInt(3, newTypicalDay.ordinal()+1);
        statement.setInt(4, newTimeSlot.ordinal()+1);

        statement.executeUpdate();

    }

}
