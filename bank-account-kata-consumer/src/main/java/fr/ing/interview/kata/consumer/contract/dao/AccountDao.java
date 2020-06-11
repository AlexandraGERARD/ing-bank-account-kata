package fr.ing.interview.kata.consumer.contract.dao;

import fr.ing.interview.kata.consumer.impl.dao.AccountDaoImpl;
import fr.ing.interview.kata.model.bean.Account;
import fr.ing.interview.kata.model.exception.NotFoundException;
import fr.ing.interview.kata.model.exception.TooManyResultsException;

import java.util.List;

/**
 * Interface of the class {@link AccountDaoImpl}
 */
public interface AccountDao {

    List<Account> getAccountsListByUser(Integer userId);

    Account getAccountByNumber(String accountNumber) throws NotFoundException, TooManyResultsException;
}
