package fr.ing.interview.kata.consumer.impl.mapper;

import fr.ing.interview.kata.consumer.impl.extractor.AccountResultSetExtractor;
import fr.ing.interview.kata.model.bean.Account;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class parsing a Row to a {@link Account}
 */
@Service
public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        AccountResultSetExtractor extractor = new AccountResultSetExtractor();
        return extractor.extractData(resultSet);
    }
}
