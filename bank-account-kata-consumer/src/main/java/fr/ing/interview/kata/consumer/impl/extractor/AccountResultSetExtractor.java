package fr.ing.interview.kata.consumer.impl.extractor;

import fr.ing.interview.kata.model.bean.Account;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class parsing a ResultSet to a {@link Account}
 */
public class AccountResultSetExtractor implements ResultSetExtractor<Account> {

    @Override
    public Account extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Account account = new Account();
        account.setAccountNumber(resultSet.getString(1));
        account.setUserId(resultSet.getInt(2));
        account.setBalance(resultSet.getDouble(3));

        return account;
    }
}
