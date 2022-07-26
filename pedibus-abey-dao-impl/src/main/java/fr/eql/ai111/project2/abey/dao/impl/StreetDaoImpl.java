package fr.eql.ai111.project2.abey.dao.impl;

import fr.eql.ai111.project2.abey.dao.StreetDao;
import fr.eql.ai111.project2.abey.dao.impl.connection.PedibusAbeyDataSource;
import fr.eql.ai111.project2.abey.entity.City;
import fr.eql.ai111.project2.abey.entity.Street;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StreetDaoImpl implements StreetDao {

    private static final Logger logger = LogManager.getLogger();
    private final DataSource dataSource = new PedibusAbeyDataSource();

    private static final String REQ_FIND_BY_CITY = "SELECT s.id_street, a.street_number";

    @Override
    public List<Street> findByCity(City city) {
        List<City> cities = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(REQ_FIND_BY_CITY);
        } catch (SQLException e) {
            logger.error("Une erreur c'est produite lors de la consutlation des villes en base de donnée", e);
        }
        return null;
    }
}
