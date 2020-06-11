package fr.ing.interview.kata.business.impl.manager;

import fr.ing.interview.kata.business.contract.manager.AccountManager;
import fr.ing.interview.kata.consumer.contract.dao.AccountDao;
import fr.ing.interview.kata.model.bean.Account;
import fr.ing.interview.kata.model.exception.NotFoundException;
import fr.ing.interview.kata.model.exception.TooManyResultsException;

import javax.inject.Named;
import java.util.List;

/**
 * Business class that communicates with the {@link AccountDao}
 */
@Named("accountManager")
public class AccountManagerImpl extends AbstractManager implements AccountManager {

    @Override
    public List<Account> getAccountsListByUser(Integer userId) {
        AccountDao accountdao = getDaoFactory().getAccountDao();
        List<Account> listOfAccounts = accountdao.getAccountsListByUser(userId);
        return listOfAccounts;
    }

    @Override
    public Account getAccountByNumber(String accountNumber) throws NotFoundException, TooManyResultsException {
        AccountDao accountdao = getDaoFactory().getAccountDao();
        Account account = accountdao.getAccountByNumber(accountNumber);
        return account;
    }

    @Override
    public void updateBalance(String accountNumber, double balance) {
        AccountDao accountdao = getDaoFactory().getAccountDao();
        accountdao.updateBalance(accountNumber, balance);
    }
}
