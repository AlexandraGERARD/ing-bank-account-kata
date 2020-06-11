package fr.ing.interview.kata.consumer.contract.dao;

import fr.ing.interview.kata.consumer.impl.dao.TransactionDaoImpl;
import fr.ing.interview.kata.model.bean.Transaction;

import java.util.List;

/**
 * Interface of the class {@link TransactionDaoImpl}
 */
public interface TransactionDao {

    List<Transaction> getTransactionsListByAccount(String accountNumber);

    void createTransaction(String accountNumber, double amount);
}
