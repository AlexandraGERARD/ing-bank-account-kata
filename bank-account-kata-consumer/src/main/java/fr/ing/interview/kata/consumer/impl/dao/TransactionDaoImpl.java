package fr.ing.interview.kata.consumer.impl.dao;

import fr.ing.interview.kata.consumer.contract.dao.TransactionDao;
import fr.ing.interview.kata.consumer.impl.mapper.TransactionRowMapper;
import fr.ing.interview.kata.model.bean.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Class that communicates with the database (table DB_TRANSACTION)
 */
@Repository("transactionDao")
public class TransactionDaoImpl extends AbstractDaoImpl implements TransactionDao {

    @Autowired
    TransactionRowMapper transactionRowMapper;

    @Override
    public List<Transaction> getTransactionsListByAccount(String accountNumber) {
        String query = "SELECT TRANSACTION_ID, ACCOUNT_NUMBER, DATE, AMOUNT FROM DB_TRANSACTION WHERE ACCOUNT_NUMBER = ? ORDER BY DATE DESC";

        JdbcTemplate template = new JdbcTemplate(getDataSource());

        List<Transaction> transactionList = template.query(query, new Object[]{accountNumber}, transactionRowMapper);

        return transactionList;
    }

    @Override
    public void createTransaction(String accountNumber, double amount) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formater.format(new Date());

        StringBuilder query = new StringBuilder("INSERT INTO DB_TRANSACTION (ACCOUNT_NUMBER, AMOUNT, DATE) VALUES ('");
        query.append(accountNumber).append("', ");
        query.append(amount).append(", '");
        query.append(dateString).append("')");

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DB_BANK",
                "postgres", "admin"); Statement stmt = conn.createStatement()) {
            Class.forName("org.postgresql.Driver");

            stmt.executeUpdate(query.toString());
        } catch (SQLException | ClassNotFoundException e) {
            //
        }
    }
}
