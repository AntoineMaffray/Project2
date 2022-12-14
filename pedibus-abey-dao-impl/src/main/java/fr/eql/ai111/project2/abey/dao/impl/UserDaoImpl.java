package fr.eql.ai111.project2.abey.dao.impl;

import fr.eql.ai111.project2.abey.dao.UserDao;
import fr.eql.ai111.project2.abey.dao.impl.connection.PedibusAbeyDataSource;
import fr.eql.ai111.project2.abey.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;

@Remote(UserDao.class)
@Stateless
public class UserDaoImpl implements UserDao {

    String test = "test";

    private static final Logger logger = LogManager.getLogger();
    private final DataSource dataSource = new PedibusAbeyDataSource();

    private static final String REQ_REG_USER =
            "insert into user (login_user, " +
                    "password_user, " +
                    "name_user, " +
                    "firstname_user, " +
                    "birthdate_user, " +
                    "phone_user, " +
                    "mail_user, " +
                    "date_creation_account, " +
                    "address_id) " +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?) " +
            ";";

    private static final  String REQ_FIND_CHILDREN =
            "SELECT  c.firstname_child, c.name_child, c.birthdate_child" +
            "FROM user u, child c " +
            "WHERE u.id_user = ? AND u.id_user = c.user_id_1 " +
            "ORDER BY c.firstname_child";


    private static final String REQ_AUTH = "SELECT * FROM user WHERE login_user = ? AND password_user = ?";

    @Override
    public User authenticate(String login, String password) {
        User user = null;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(REQ_AUTH);
            statement.setString(1,login);
            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id_user"),
                        resultSet.getString("login_user"),
                        resultSet.getString("password_user"),
                        resultSet.getString("name_user"),
                        resultSet.getString("firstname_user"),
                        resultSet.getDate("birthdate_user"),
                        resultSet.getString("phone_user"),
                        resultSet.getString("mail_user"),
                        resultSet.getDate("date_creation_account"),
                        resultSet.getInt("address_id")
                );
            }
            connection.close();
        } catch (SQLException e) {
            logger.error("Une erreure s'est produite lors de la consultation de l'utilisateur en base de donn??e.", e);
        }
        return user;
    }

    @Override
    public void registerUser(User user) {

        try (Connection connection = dataSource.getConnection()){
            connection.setAutoCommit(false);
            int id = registerUserStatementExecution(user, connection);
            if (id <= 0)
                connection.rollback();
            connection.commit();
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de l'??criture " +
                    "de l'utilisateur en base de donn??es", e);
        }
    }

    private int registerUserStatementExecution (User user, Connection connection) throws SQLException {
        int id = 0;
        PreparedStatement statement = connection.prepareStatement(REQ_REG_USER, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, user.getLoginUser());
        statement.setString(2, user.getPasswordUser());
        statement.setString(3, user.getNameUser());
        statement.setString(4, user.getFirstnameUser());
        statement.setDate(5, new Date(user.getBirthDateUser().getTime()));
        statement.setString(6, user.getPhoneUser());
        statement.setString(7, user.getMailUser());
        statement.setDate(8, new Date(user.getDateCreationAccountUser().getTime()));
        statement.setInt(9, user.getAddressIdUser());
        int affectedRows = statement.executeUpdate();
        if (affectedRows > 0) {
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    id = resultSet.getInt(1);
                    user.setIdUser(id);
                }
            } catch (SQLException e) {
                connection.rollback();
                logger.error("Une erreur s'est produite lors de la r??cup??ration de l'id " +
                        "de l'utilisateur ins??r??.", e);
            }
        }
        return id;
    }

    @Override
    public void findChildren(User user) {

        try (Connection connection = dataSource.getConnection()){
            connection.setAutoCommit(false);
            findChildrenStatement(user, connection);
            connection.commit();
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de la r??cup??ration des enfants en base de donn??es", e);
        }
    }

    private void findChildrenStatement (User user, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(REQ_FIND_CHILDREN, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, user.getIdUser());
        statement.executeUpdate();
    }

}
