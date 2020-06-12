package fr.ing.interview.kata.business.impl;


import fr.ing.interview.kata.business.contract.ManagerFactory;
import fr.ing.interview.kata.business.contract.manager.AccountManager;
import fr.ing.interview.kata.business.contract.manager.TransactionManager;
import fr.ing.interview.kata.business.contract.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class that gives access to the different managers: {@link AccountManager}, {@link TransactionManager} and {@link UserManager}
 */
@Component("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {

    @Autowired
    private AccountManager accountManager;

    @Autowired
    private TransactionManager transactionManager;

    @Autowired
    private UserManager userManager;

    //----------------- GETTERS/SETTERS -----------------//
    @Override
    public AccountManager getAccountManager() {
        return this.accountManager;
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    @Override
    public TransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
}
