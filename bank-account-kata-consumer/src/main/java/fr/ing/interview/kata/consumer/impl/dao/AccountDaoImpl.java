package fr.ing.interview.kata.consumer.impl.dao;

import fr.ing.interview.kata.consumer.contract.dao.AccountDao;
import fr.ing.interview.kata.consumer.impl.mapper.AccountRowMapper;
import fr.ing.interview.kata.model.bean.Account;
import fr.ing.interview.kata.model.exception.NotFoundException;
import fr.ing.interview.kata.model.exception.TooManyResultsException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Class that communicates with the database (table DB_ACCOUNT)
 */
@Named("accountDao")
public class AccountDaoImpl extends AbstractDaoImpl implements AccountDao {

    @Inject
    AccountRowMapper accountRowMapper;

    @Override
    public List<Account> getAccountsListByUser(Integer userId) throws DataAccessException {
        String query = "SELECT ACCOUNT_NUMBER, USER_ID, BALANCE FROM DB_ACCOUNT WHERE USER_ID = ?";

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
}
