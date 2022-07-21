package fr.eql.ai111.project2.abey.dao.impl;

import fr.eql.ai111.project2.abey.dao.UserDao;
import fr.eql.ai111.project2.abey.dao.impl.connection.PedibusAbeyDataSource;
import fr.eql.ai111.project2.abey.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    String test = "test";

    private static final Logger logger = LogManager.getLogger();

    private static final String REQ_REG_USER =
            "insert into user (login_user, " +
                    "password_user, " +
                    "name_user, " +
                    "firstname_user, " +
                    "birthdate_user, " +
                    "phone_user, " +
                    "mail_user, " +
                    "date_creation_account) " +
            "values (?, ?, ?, ?, ?, ?, ?, ?) " +
            ";";

    private final DataSource dataSource = new PedibusAbeyDataSource();

    @Override
    public User register(
            String login,
            String password,
            String name,
            String firstname,
            Date birthDate,
            String phone,
            String mail,
            Date dateCreationAccount) {

        User user = null;

        try {
            Connection connection = dataSource.getConnection();
        } catch (SQLException e) {
            logger.error("Une erreur s'est produite lors de l'écriture " +
                    "de l'utilisateur en base de données", e);
        }

        return user;
    }
}
