package fr.ing.interview.kata.consumer.contract;

import fr.ing.interview.kata.consumer.contract.dao.AccountDao;
import fr.ing.interview.kata.consumer.contract.dao.TransactionDao;
import fr.ing.interview.kata.consumer.contract.dao.UserDao;

/**
 * Interface that gives access to the Dao interfaces : {@link AccountDao}, {@link TransactionDao} and {@link UserDao}
 */
public interface DaoFactory {

    AccountDao getAccountDao();

    TransactionDao getTransactionDao();

    UserDao getUserDao();
}
