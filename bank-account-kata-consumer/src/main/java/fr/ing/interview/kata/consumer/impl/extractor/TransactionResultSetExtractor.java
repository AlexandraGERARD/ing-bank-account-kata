package fr.ing.interview.kata.consumer.impl.extractor;

import fr.ing.interview.kata.model.bean.Transaction;
import fr.ing.interview.kata.model.bean.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class parsing a ResultSet to a {@link Transaction}
 */
public class TransactionResultSetExtractor implements ResultSetExtractor<Transaction> {

    @Override
    public Transaction extractData(ResultSet resultSet) throws SQLException, DataAccessException {
       return null;
    }
}
