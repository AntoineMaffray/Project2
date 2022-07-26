package fr.eql.ai111.project2.abey.dao.impl;

import fr.eql.ai111.project2.abey.dao.StreetDao;
import fr.eql.ai111.project2.abey.dao.impl.connection.PedibusAbeyDataSource;
import fr.eql.ai111.project2.abey.entity.Street;
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

@Remote(StreetDao.class)
@Stateless
public class StreetDaoImpl implements StreetDao {

    private static final Logger logger  = LogManager.getLogger();
    private final DataSource dataSource = new PedibusAbeyDataSource();

    private static final String REQ_FIND_ALL_STREETS = "SELECT * FROM street " +
            "ORDER BY name_street";

    @Override
    public List<Street> findAllStreets() {
        List<Street> streets = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(REQ_FIND_ALL_STREETS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                streets.add(new Street(
                        resultSet.getInt("id_street"),
                        resultSet.getString("name_street")
                ));
            }
            connection.close();
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de la consultation des rues en base de données", e);
        }
        return streets;
    }
}
