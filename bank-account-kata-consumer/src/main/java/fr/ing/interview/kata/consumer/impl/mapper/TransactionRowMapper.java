package fr.ing.interview.kata.consumer.impl.mapper;

import fr.ing.interview.kata.model.bean.Account;
import fr.ing.interview.kata.model.bean.Transaction;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class parsing a Row to a {@link Transaction}
 */
@Named("transactionRowMapper")
public class TransactionRowMapper implements RowMapper<Transaction> {

    @Override
    public Transaction mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}
