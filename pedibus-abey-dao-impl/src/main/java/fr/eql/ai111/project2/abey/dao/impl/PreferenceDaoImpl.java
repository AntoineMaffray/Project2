package fr.eql.ai111.project2.abey.dao.impl;

import fr.eql.ai111.project2.abey.dao.PreferenceDao;
import fr.eql.ai111.project2.abey.dao.impl.connection.PedibusAbeyDataSource;
import fr.eql.ai111.project2.abey.entity.Preference;
import fr.eql.ai111.project2.abey.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;

@Remote(PreferenceDao.class)
@Stateless
public class PreferenceDaoImpl implements PreferenceDao {

    private static final Logger logger = LogManager.getLogger();

    private static final String REQ_REG_PREFERENCE =
            "insert into preference (user_id, " +
                    "timeslot_id, " +
                    "typical_day_id) " +
                    "values (?, ?, ?) " +
                    ";";

    private final DataSource dataSource = new PedibusAbeyDataSource();

    @Override
    public void registerPreference(Preference preference, User user) {

        try (Connection connection = dataSource.getConnection()){
            connection.setAutoCommit(false);
            int id = registerPreferenceStatementExecution(preference, user, connection);
            if (id <= 0)
                connection.rollback();
            connection.commit();
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de l'écriture " +
                    "de l'utilisateur en base de données", e);
        }
    }

    private int registerPreferenceStatementExecution (Preference preference, User user, Connection connection) throws SQLException {
        int id = 0;
        PreparedStatement statement = connection.prepareStatement(REQ_REG_PREFERENCE, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, user.getIdUser());
        statement.setInt(2, preference.getTimeSlotId().ordinal()+1);
        statement.setInt(3, preference.getTypicalDayId().ordinal()+1);

        int affectedRows = statement.executeUpdate();
        if (affectedRows > 0) {
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    id = resultSet.getInt(1);
                    preference.setpreferenceId(id);
                }
            } catch (SQLException e) {
                connection.rollback();
                logger.error("Une erreur s'est produite lors de la récupération de l'id " +
                        "de l'utilisateur inséré.", e);
            }
        }

        return id;
    }

}
