package fr.ing.interview.kata.consumer.impl.dao;

import fr.ing.interview.kata.consumer.contract.dao.UserDao;
import fr.ing.interview.kata.consumer.impl.mapper.UserRowMapper;
import fr.ing.interview.kata.model.bean.User;
import fr.ing.interview.kata.model.exception.NotFoundException;
import fr.ing.interview.kata.model.exception.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class that communicates with the database (table DB_USER)
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDaoImpl implements UserDao {

    @Autowired
    UserRowMapper userRowMapper;

    @Override
    public User getByLoginAndPassword(String login, String password) throws NotFoundException, TooManyResultsException {
        String query = "SELECT USER_ID, LOGIN, PASSWORD FROM DB_USER WHERE LOGIN = ? AND PASSWORD = ?";

        JdbcTemplate template = new JdbcTemplate(getDataSource());

        List<User> usersList = template.query(query, new Object[]{login, password}, userRowMapper);

        if (usersList.isEmpty()) {
            throw new NotFoundException();
        }

        if (usersList.size() > 1) {
            throw new TooManyResultsException();
        }

        User user = usersList.get(0);
        return user;
    }
}
