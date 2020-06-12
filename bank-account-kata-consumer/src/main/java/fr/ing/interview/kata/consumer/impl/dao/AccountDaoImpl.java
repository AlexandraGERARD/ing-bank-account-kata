package fr.ing.interview.kata.consumer.impl.dao;

import fr.ing.interview.kata.consumer.contract.dao.AccountDao;
import fr.ing.interview.kata.consumer.impl.mapper.AccountRowMapper;
import fr.ing.interview.kata.model.bean.Account;
import fr.ing.interview.kata.model.exception.NotFoundException;
import fr.ing.interview.kata.model.exception.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Class that communicates with the database (table DB_ACCOUNT)
 */
@Repository("accountDao")
public class AccountDaoImpl extends AbstractDaoImpl implements AccountDao {

    @Autowired
    AccountRowMapper accountRowMapper;

    @Override
    public List<Account> getAccountsListByUser(Integer userId) {
        String query = "SELECT ACCOUNT_NUMBER, USER_ID, BALANCE FROM DB_ACCOUNT WHERE USER_ID = ? ORDER BY ACCOUNT_NUMBER ASC";

        JdbcTemplate template = new JdbcTemplate(getDataSource());

        List<Account> accountsList = template.query(query, new Object[]{userId}, accountRowMapper);

        return accountsList;
    }

    @Override
    public Account getAccountByNumber(String accountNumber) throws NotFoundException, TooManyResultsException {
        String query = "SELECT ACCOUNT_NUMBER, USER_ID, BALANCE FROM DB_ACCOUNT WHERE ACCOUNT_NUMBER = ?";

        JdbcTemplate template = new JdbcTemplate(getDataSource());

        List<Account> accountsList = template.query(query, new Object[]{accountNumber}, accountRowMapper);

        if (accountsList.isEmpty()) {
            throw new NotFoundException();
        }

        if (accountsList.size() > 1) {
            throw new TooManyResultsException();
        }

        Account account = accountsList.get(0);
        return account;
    }

    @Override
    public void updateBalance(String accountNumber, double balance) {
        StringBuilder query = new StringBuilder("UPDATE DB_ACCOUNT SET BALANCE = ");
        query.append(balance);
        query.append(" WHERE ACCOUNT_NUMBER = '");
        query.append(accountNumber).append("'");

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DB_BANK",
                "postgres", "admin"); Statement stmt = conn.createStatement()) {
            Class.forName("org.postgresql.Driver");

            stmt.executeUpdate(query.toString());
        } catch (SQLException | ClassNotFoundException e) {
            //
        }
    }
}
