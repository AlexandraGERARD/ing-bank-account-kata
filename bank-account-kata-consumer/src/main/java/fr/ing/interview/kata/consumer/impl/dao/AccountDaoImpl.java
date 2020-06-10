package fr.ing.interview.kata.consumer.impl.dao;

import fr.ing.interview.kata.consumer.contract.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;

/**
 * Class that communicates with the database (table ACCOUNT)
 */
@Named
public class AccountDaoImpl extends AbstractDaoImpl implements AccountDao {

    @Override
    public int getNbOfAccounts() {
        JdbcTemplate template = new JdbcTemplate(getDataSource());

        int nbOfAccounts = template.queryForObject(
                "SELECT COUNT(*) FROM ACCOUNT",
                Integer.class);

        return nbOfAccounts;
    }
}
