package fr.ing.interview.kata.business.contract;

import fr.ing.interview.kata.business.contract.manager.AccountManager;
import fr.ing.interview.kata.business.contract.manager.TransactionManager;
import fr.ing.interview.kata.business.contract.manager.UserManager;

public interface ManagerFactory {
    AccountManager getAccountManager();

    TransactionManager getTransactionManager();

    UserManager getUserManager();
}
