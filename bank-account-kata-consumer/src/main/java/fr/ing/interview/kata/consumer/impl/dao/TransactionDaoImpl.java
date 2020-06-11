package fr.ing.interview.kata.consumer.impl.dao;

import fr.ing.interview.kata.consumer.contract.dao.TransactionDao;
import fr.ing.interview.kata.consumer.impl.mapper.TransactionRowMapper;
import fr.ing.interview.kata.model.bean.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Class that communicates with the database (table DB_TRANSACTION)
 */
@Named("transactionDao")
public class TransactionDaoImpl extends AbstractDaoImpl implements TransactionDao {

    @Inject
    TransactionRowMapper transactionRowMapper;

    @Override
    public List<Transaction> getTransactionsListByAccount(String accountNumber) {
        String query = "SELECT TRANSACTION_ID, ACCOUNT_NUMBER, DATE, AMOUNT FROM DB_TRANSACTION WHERE ACCOUNT_NUMBER = ? ORDER BY DATE DESC";

        JdbcTemplate template = new JdbcTemplate(getDataSource());

        List<Transaction> transactionList = template.query(query, new Object[]{accountNumber}, transactionRowMapper);

        return transactionList;
    }
}
