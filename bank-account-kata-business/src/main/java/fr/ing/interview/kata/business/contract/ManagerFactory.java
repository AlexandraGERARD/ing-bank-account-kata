package fr.ing.interview.kata.business.contract;

import fr.ing.interview.kata.business.contract.manager.AccountManager;
import fr.ing.interview.kata.business.contract.manager.TransactionManager;
import fr.ing.interview.kata.business.contract.manager.UserManager;
import fr.ing.interview.kata.business.impl.ManagerFactoryImpl;

/**
 * Interface of the {@link ManagerFactoryImpl}
 */
public interface ManagerFactory {

    AccountManager getAccountManager();

    TransactionManager getTransactionManager();

    UserManager getUserManager();
}
