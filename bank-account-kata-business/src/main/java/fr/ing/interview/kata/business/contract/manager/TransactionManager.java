package fr.ing.interview.kata.business.contract.manager;

import fr.ing.interview.kata.business.impl.manager.TransactionManagerImpl;
import fr.ing.interview.kata.model.bean.Transaction;

import java.util.List;

/**
 * Interface of the class {@link TransactionManagerImpl}
 */
public interface TransactionManager {

    List<Transaction> getTransactionsListByAccount(String accountNumber);

    void createTransaction(String accountNumber, double amount);
}
