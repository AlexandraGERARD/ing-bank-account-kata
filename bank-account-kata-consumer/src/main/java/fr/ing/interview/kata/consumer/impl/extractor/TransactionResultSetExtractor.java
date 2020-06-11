package fr.ing.interview.kata.consumer.impl.extractor;

import fr.ing.interview.kata.model.bean.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class parsing a ResultSet to a {@link Transaction}
 */
public class TransactionResultSetExtractor implements ResultSetExtractor<Transaction> {

    @Override
    public Transaction extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(resultSet.getInt(1));
        transaction.setAccountNumber(resultSet.getString(2));
        transaction.setDate(resultSet.getDate(3));

        double amount = resultSet.getDouble(4);
        double amountWithPrecision = BigDecimal.valueOf(amount)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
        transaction.setAmount(amountWithPrecision);

        return transaction;
    }
}
