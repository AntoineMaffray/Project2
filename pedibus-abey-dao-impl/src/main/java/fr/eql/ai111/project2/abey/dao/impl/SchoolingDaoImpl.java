package fr.eql.ai111.project2.abey.dao.impl;
import fr.eql.ai111.project2.abey.dao.SchoolingDao;
import fr.eql.ai111.project2.abey.dao.impl.connection.PedibusAbeyDataSource;
import fr.eql.ai111.project2.abey.entity.Child;
import fr.eql.ai111.project2.abey.entity.School;
import fr.eql.ai111.project2.abey.entity.Schooling;
import fr.eql.ai111.project2.abey.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;

@Remote(SchoolingDao.class)
@Stateless
public class SchoolingDaoImpl implements SchoolingDao {

    School school = School.HAUT_MESNIL;
    
    private static final Logger logger = LogManager.getLogger();

    private static final String REQ_REG_SCHOOLING =
            "insert into schooling (school_id, " +
                    "school_year_id, " +
                    "school_level_id, " +
                    "child_id) " +
                    "values (?, 1, ?, ?) " +
                    ";";

    private final DataSource dataSource = new PedibusAbeyDataSource();

    @Override
    public void registerSchooling(Schooling schooling, User user, int childId) {

        try (Connection connection = dataSource.getConnection()){
            connection.setAutoCommit(false);
            int id = registerSchoolingStatementExecution(schooling, user, childId, connection);
            if (id <= 0)
                connection.rollback();
            connection.commit();
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de l'écriture " +
                    "de l'utilisateur en base de données", e);
        }
    }

    private int registerSchoolingStatementExecution (Schooling schooling, User user, int childId, Connection connection) throws SQLException {
        int id = 0;
        PreparedStatement statement = connection.prepareStatement(REQ_REG_SCHOOLING, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, schooling.getIdSchool().ordinal()+1);
        statement.setInt(2, schooling.getIdSchoolLevel().ordinal()+1);
        statement.setInt(3, childId);

        int affectedRows = statement.executeUpdate();
        if (affectedRows > 0) {
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    id = resultSet.getInt(1);
                    schooling.setIdSchooling(id);
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
