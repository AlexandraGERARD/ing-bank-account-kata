package fr.ing.interview.kata.business.contract.manager;

import fr.ing.interview.kata.business.impl.manager.AccountManagerImpl;
import fr.ing.interview.kata.model.bean.Account;
import fr.ing.interview.kata.model.exception.NotFoundException;
import fr.ing.interview.kata.model.exception.TooManyResultsException;

import java.util.List;

/**
 * Interface of the class {@link AccountManagerImpl}
 */
public interface AccountManager {

    List<Account> getAccountsListByUser(Integer userId);

    Account getAccountByNumber(String accountNumber) throws NotFoundException, TooManyResultsException;

    void updateBalance(String accountNumber, double balance);
}
