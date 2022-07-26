package fr.eql.ai111.project2.abey.dao.impl;

import fr.eql.ai111.project2.abey.dao.AddressDao;
import fr.eql.ai111.project2.abey.dao.impl.connection.PedibusAbeyDataSource;
import fr.eql.ai111.project2.abey.entity.Address;
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

@Remote(AddressDao.class)
@Stateless
public class AddressDaoImpl implements AddressDao {

    private static final Logger logger = LogManager.getLogger();
    private final DataSource dataSource = new PedibusAbeyDataSource();

    private static final String REQ_FIND_BY_STREET = "SELECT a.id_address, s.name_street, a.street_number " +
            "from address a, street s " +
            "WHERE a.street_id = ? AND a.street_id = s.id_street " +
            "ORDER BY s.name_street";

    @Override
    public List<Address> findByStreet(Street street) {
        List<Address> addresses = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(REQ_FIND_BY_STREET);
            statement.setInt(1, street.getIdStreet());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                addresses.add(new Address(
                        resultSet.getInt("id_address"),
                        resultSet.getString("street_number"))
                );
            }
            connection.close();
        } catch (SQLException e) {
            logger.error("Une erreur c'est produite lors de la consutlation des villes en base de donnée", e);
        }
        return addresses;
    }

}
