package fr.eql.ai111.project2.abey.dao.impl;

import fr.eql.ai111.project2.abey.dao.LineDao;
import fr.eql.ai111.project2.abey.dao.StopDao;
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

@Remote(StopDao.class)
@Stateless
public class StopDaoImpl implements StopDao {

    private static final Logger logger = LogManager.getLogger();
    private final DataSource dataSource = new PedibusAbeyDataSource();

    private static final String REQ_FIND_BY_LINE = "SELECT s.id_stop, s.name_stop, s.address_id " +
            "FROM stop s, trip t, line l " +
            "WHERE t.line_id = ? " +
            "AND t.line_id = l.id_line " +
            "AND t.stop_id = s.id_stop " +
            "ORDER BY t.order_trip";

    private static final String REQ_FIND_ALL_STOPS = "SELECT * FROM stop ORDER BY name_stop";

    private static final String REQ_ADD_STOP =
            "insert into stop (name_stop, " +
                    "address_id) " +
                    "values (?, ?) " +
                    ";";

    @Override
    public List<Stop> findByLine(Line line) {
        List<Stop> stops = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(REQ_FIND_BY_LINE);
            statement.setInt(1, line.getIdLine());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                stops.add(new Stop(
                      resultSet.getInt("id_stop"),
                      resultSet.getString("name_stop"),
                      resultSet.getInt("address_id")
                ));
            }
            connection.close();
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de la consultation des arrêts en base de données", e);
        }
        return stops;
    }

    @Override
    public List<Stop> findAllStops() {
        List<Stop> stops = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(REQ_FIND_ALL_STOPS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                stops.add(new Stop(
                        resultSet.getInt("id_stop"),
                        resultSet.getString("name_stop"),
                        resultSet.getInt("address_id")
                ));
            }
            connection.close();
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de la consultation des arrêts en base de données.", e);
        }
        return stops;
    }

    @Override
    public void addStop(Stop stop) {

        try (Connection connection = dataSource.getConnection()){
            connection.setAutoCommit(false);
            int id = addStopStatementExecution(stop, connection);
            if (id <= 0)
                connection.rollback();
            connection.commit();
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de l'écriture " +
                    "de l'arrêt en base de données", e);
        }
    }

    private int addStopStatementExecution (Stop stop, Connection connection) throws SQLException {
        int id = 0;
        PreparedStatement statement = connection.prepareStatement(REQ_ADD_STOP, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, stop.getNameStop());
        statement.setInt(2, stop.getAddressIdStop());

        int affectedRows = statement.executeUpdate();
        if (affectedRows > 0) {
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    id = resultSet.getInt(1);
                    stop.setIdStop(id);
                }
            } catch (SQLException e) {
                connection.rollback();
                logger.error("Une erreur s'est produite lors de la récupération de l'id " +
                        "de l'arrêt en base de données.", e);
            }
        }

        return id;
    }
}
