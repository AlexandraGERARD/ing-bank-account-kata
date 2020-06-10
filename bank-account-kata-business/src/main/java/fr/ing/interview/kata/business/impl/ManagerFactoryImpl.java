package fr.ing.interview.kata.business.impl;


import fr.ing.interview.kata.business.contract.ManagerFactory;
import fr.ing.interview.kata.business.contract.manager.AccountManager;
import fr.ing.interview.kata.business.contract.manager.TransactionManager;
import fr.ing.interview.kata.business.contract.manager.UserManager;

import javax.inject.Inject;
import javax.inject.Named;

@Named("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {

    @Inject
    private AccountManager accountManager;

    @Inject
    private TransactionManager transactionManager;

    @Inject
    private UserManager userManager;

    @Override
    public AccountManager getAccountManager(){
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
