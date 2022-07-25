package fr.eql.ai111.project2.abey.dao.impl;

import fr.eql.ai111.project2.abey.dao.ChildDao;
import fr.eql.ai111.project2.abey.dao.SchoolYearDao;
import fr.eql.ai111.project2.abey.dao.impl.connection.PedibusAbeyDataSource;
import fr.eql.ai111.project2.abey.entity.SchoolYear;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;


@Remote(SchoolYearDao.class)
@Stateless

public class SchoolYearDaoImpl implements SchoolYearDao {

    private static final Logger logger = LogManager.getLogger();

    private static final String REQ_REG_SCHOOLYEAR =
            "insert into schooling (school_id, " +
                    "school_year_id, " +
                    "school_level_id, " +
                    "child_id) " +
                    "values (?, ?, ?, ?) " +
                    ";";

    private final DataSource dataSource = new PedibusAbeyDataSource();

    @Override
    public void registerSchoolYear(SchoolYear schoolYear) {

        try (Connection connection = dataSource.getConnection()){
            connection.setAutoCommit(false);
            int id = registerschoolYearStatementExecution(schoolYear, connection);
            if (id <= 0)
                connection.rollback();
            connection.commit();
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de l'écriture " +
                    "de l'année scolaire en base de données", e);
        }
    }

    private int registerschoolYearStatementExecution (SchoolYear schoolYear, Connection connection) throws SQLException {
        int id = 0;
        PreparedStatement statement = connection.prepareStatement(REQ_REG_SCHOOLYEAR, Statement.RETURN_GENERATED_KEYS);
        statement.setDate(1, new Date(schoolYear.getDateStartSchoolYear().getTime()));
        statement.setDate(2, new Date(schoolYear.getDateEndSchoolYear().getTime()));
        int affectedRows = statement.executeUpdate();
        if (affectedRows > 0) {
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    id = resultSet.getInt(1);
                    schoolYear.setIdSchoolYear(id);
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
