package fr.eql.ai111.project2.abey.dao.impl;

import fr.eql.ai111.project2.abey.dao.LineDao;
import fr.eql.ai111.project2.abey.dao.StopDao;
import fr.eql.ai111.project2.abey.dao.impl.connection.PedibusAbeyDataSource;
import fr.eql.ai111.project2.abey.entity.Line;
import fr.eql.ai111.project2.abey.entity.Stop;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
