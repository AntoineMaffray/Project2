package fr.eql.ai111.project2.abey.dao.impl;

import fr.eql.ai111.project2.abey.dao.LineDao;
import fr.eql.ai111.project2.abey.dao.impl.connection.PedibusAbeyDataSource;
import fr.eql.ai111.project2.abey.entity.Line;
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

@Remote(LineDao.class)
@Stateless
public class LineDaoImpl implements LineDao {

    private static final Logger logger = LogManager.getLogger();
    private final DataSource dataSource = new PedibusAbeyDataSource();

    private static final String REQ_FIND_ALL_LINES = "SELECT * FROM line ORDER BY name_line ";

    @Override
    public List<Line> findAllLines() {
        List<Line> lines = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(REQ_FIND_ALL_LINES);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lines.add(new Line(
                        resultSet.getInt("id_line"),
                        resultSet.getString("name_line"),
                        resultSet.getDate("date_creation_line"),
                        resultSet.getDate("date_end_line")
                ));
            }
            connection.close();
        } catch (SQLException e) {
            logger.error("Une erreur c'est produite lors de la consultation des lignes en base de données.", e);
        }
        return lines;
    }
}
