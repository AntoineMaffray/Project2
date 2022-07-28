package fr.eql.ai111.project2.abey.dao.impl;

import fr.eql.ai111.project2.abey.dao.LineDao;
import fr.eql.ai111.project2.abey.dao.impl.connection.PedibusAbeyDataSource;
import fr.eql.ai111.project2.abey.entity.Line;
import fr.eql.ai111.project2.abey.entity.Stop;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Remote(LineDao.class)
@Stateless
public class LineDaoImpl implements LineDao {

    private static Logger logger = LogManager.getLogger();
    private final DataSource dataSource = new PedibusAbeyDataSource();

    private static final String REQ_FIND_ALL_LINES = "SELECT * FROM line ORDER BY name_line ";

    private static final String REQ_CREATE_LINE =
            "insert into line (id_line, " +
                    "name_line, " +
                    "date_creation_line, " +
                    "date_end_line) " +
                    "values (?, ?, ?, ?) " +
                    ";";

    private static final String REQ_FILL_LINE_WITH_STOPS = "INSERT INTO trip (id_trip, " +
            "date_attribution_trip, " +
            "date_cancellation_trip, " +
            "order_trip, line_id, stop_id) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

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
                        resultSet.getString("name_line")
                ));
            }
            connection.close();
        } catch (SQLException e) {
            logger.error("Une erreur c'est produite lors de la consultation des lignes en base de données.", e);
        }
        return lines;
    }

    @Override
    public int createLine(Line newLine) {
        int id = 0;

        try (Connection connection = dataSource.getConnection()){
            connection.setAutoCommit(false);
            id = createLineStatementExecution(newLine, connection);
            if (id <= 0)
                connection.rollback();
            connection.commit();
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de l'écriture de la ligne en base de données", e);
        }

        return id;
    }
    private int createLineStatementExecution(Line newLine, Connection connection) throws SQLException {
        int id = 0;
        PreparedStatement statement = connection.prepareStatement(REQ_CREATE_LINE, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, newLine.getIdLine());
        statement.setString(2, newLine.getNameLine());
        statement.setDate(3, new Date(new java.util.Date().getTime()));
        statement.setDate(4, null);
        int affectedRows = statement.executeUpdate();
        if (affectedRows > 0) {
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if(resultSet.next()) {
                    id = resultSet.getInt(1);
                    newLine.setIdLine(id);
                }
            } catch (SQLException e) {
                connection.rollback();
                logger.error("Une erreur s'est produite lors de l'enregistrement de l'id de la ligne " +
                        "en base de données ", e);
            }
        }
        return id;
    }

    @Override
    public void addStopsToSaveToDb(List<Stop> stopsToSave, Line newLine, int idLine) {
        try (Connection connection = dataSource.getConnection()){
            connection.setAutoCommit(false);
            for (Stop stop : stopsToSave) {
                int id = addStopsToSaveToDbStatementExecution(stop, idLine, connection);
                if (id <= 0)
                    connection.rollback();
                connection.commit();
            }
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de l'association des arrêts à la ligne en base de données", e);
        }
    }

    private int addStopsToSaveToDbStatementExecution(Stop stopsToSave, int idLine, Connection connection) throws SQLException {
        int id = 0;
        PreparedStatement statement = connection.prepareStatement(REQ_FILL_LINE_WITH_STOPS, Statement.RETURN_GENERATED_KEYS);
        statement.setInt (1, 0);
        statement.setDate (2, null);
        statement.setDate (3, null);
        statement.setInt (4, 0);
        statement.setInt (5, idLine);
        statement.setInt (6, stopsToSave.getIdStop());
        int affectedRows = statement.executeUpdate();
        if (affectedRows > 0) {
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    id = resultSet.getInt(1);

                }
            } catch (SQLException e) {
                connection.rollback();
                logger.error("Une erreur s'est produite lors de la récupération des arrêts en base de données");
            }
        }
        return id;
    }
}
