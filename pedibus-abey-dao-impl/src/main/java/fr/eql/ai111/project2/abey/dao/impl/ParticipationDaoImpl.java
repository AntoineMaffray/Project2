package fr.eql.ai111.project2.abey.dao.impl;
import fr.eql.ai111.project2.abey.dao.ParticipationDAO;
import fr.eql.ai111.project2.abey.dao.SchoolingDao;
import fr.eql.ai111.project2.abey.dao.impl.connection.PedibusAbeyDataSource;
import fr.eql.ai111.project2.abey.entity.Participation;
import fr.eql.ai111.project2.abey.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;

@Remote(ParticipationDAO.class)
@Stateless

public class ParticipationDaoImpl implements ParticipationDAO {

    private static final Logger logger = LogManager.getLogger();

    private static final String REQ_REG_PARTICIPATION =
            "insert into participation (id_participation, " +
                    "user_id, " +
                    "role_id) " +
                    "values ( ?, ?, ?)" +
                    ";";

    private final DataSource dataSource = new PedibusAbeyDataSource();

    @Override
    public void registerParticipation(Participation participation, User user) {

        try (Connection connection = dataSource.getConnection()){
            connection.setAutoCommit(false);
            int id = registerParticipationStatementExecution(participation, user, connection);
            if (id <= 0)
                connection.rollback();
            connection.commit();
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de l'écriture " +
                    "du participant en base de données", e);
        }
    }
    private int registerParticipationStatementExecution(Participation participation, User user, Connection connection) throws SQLException {
        int id = 0;
        PreparedStatement statement = connection.prepareStatement(REQ_REG_PARTICIPATION, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, participation.getIdParticipation());
        statement.setInt(2, participation.getRoleId().ordinal()+1);

        int affectedRows = statement.executeUpdate();
        if (affectedRows > 0) {
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    id = resultSet.getInt(1);
                    participation.setIdParticipation(id);
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
