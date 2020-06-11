package fr.ing.interview.kata.consumer.impl.mapper;

import fr.ing.interview.kata.consumer.impl.extractor.UserResultSetExtractor;
import fr.ing.interview.kata.model.bean.User;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class parsing a Row to a {@link User}
 */
@Named("userRowMapper")
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        UserResultSetExtractor extractor = new UserResultSetExtractor();
        return extractor.extractData(resultSet);
    }
}
