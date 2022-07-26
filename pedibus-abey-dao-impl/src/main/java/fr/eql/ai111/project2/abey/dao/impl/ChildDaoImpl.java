package fr.eql.ai111.project2.abey.dao.impl;

import fr.eql.ai111.project2.abey.dao.ChildDao;
import fr.eql.ai111.project2.abey.dao.impl.connection.PedibusAbeyDataSource;
import fr.eql.ai111.project2.abey.entity.Child;
import fr.eql.ai111.project2.abey.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;


    @Remote(ChildDao.class)
    @Stateless
    public class ChildDaoImpl implements ChildDao {



        String test = "test";

        private static final Logger logger = LogManager.getLogger();

        private static final String REQ_REG_CHILD =
                "insert into child (name_child, " +
                        "firstname_child, " +
                        "birthdate_child, " +
                        "user_id_1) " +
                        "values (?, ?, ?, ?) " +
                        ";";

        private final DataSource dataSource = new PedibusAbeyDataSource();

        @Override
        public void registerChild(Child child, User user) {

            try (Connection connection = dataSource.getConnection()) {
                connection.setAutoCommit(false);
                int id = registerChildStatementExecution(child, user, connection);
                if (id <= 0)
                    connection.rollback();
                connection.commit();
            } catch (SQLException e) {
                logger.error("Une erreur s'est produite lors de l'écriture " +
                        "de l'utilisateur en base de données", e);
            }
        }

        private int registerChildStatementExecution(Child child, User user, Connection connection) throws SQLException {
            int id = 0;
            PreparedStatement statement = connection.prepareStatement(REQ_REG_CHILD, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, child.getNameChild());
            statement.setString(2, child.getFirstnameChild());
            statement.setDate(3, new Date(child.getBirthDateChild().getTime()));
            statement.setInt(4, user.getIdUser());
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet resultSet = statement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        id = resultSet.getInt(1);
                        child.setIdChild(id);
                    }
                } catch (SQLException e) {
                    connection.rollback();
                    logger.error("Une erreur s'est produite lors de la récupération de l'id " +
                            "de l'enfant inséré.", e);
                }
            }

            return id;
        }
    }

