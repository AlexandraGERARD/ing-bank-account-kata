package fr.ing.interview.kata.consumer.impl.dao;

import fr.ing.interview.kata.consumer.contract.dao.UserDao;
import fr.ing.interview.kata.model.bean.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;

/**
 * Class that communicates with the database (table USER)
 */
@Named
public class UserDaoImpl extends AbstractDaoImpl implements UserDao {

    @Override
    public User getByLoginAndPassword(String login, String password){
        String query = "SElECT * FROM USER WHERE LOGIN = ? AND PASSWORD = ?";

        JdbcTemplate template = new JdbcTemplate(getDataSource());

        User user = template.queryForObject(query,
                User.class, login, password);

        return user;
    }
}
