package fr.ing.interview.kata.consumer.impl.mapper;

import fr.ing.interview.kata.consumer.impl.extractor.TransactionResultSetExtractor;
import fr.ing.interview.kata.model.bean.Transaction;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class parsing a Row to a {@link Transaction}
 */
@Service
public class TransactionRowMapper implements RowMapper<Transaction> {

    @Override
    public Transaction mapRow(ResultSet resultSet, int i) throws SQLException {
        TransactionResultSetExtractor extractor = new TransactionResultSetExtractor();
        return extractor.extractData(resultSet);
    }
}
