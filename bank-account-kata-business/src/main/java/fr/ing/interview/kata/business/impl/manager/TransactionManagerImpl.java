package fr.ing.interview.kata.business.impl.manager;

import fr.ing.interview.kata.business.contract.manager.TransactionManager;
import fr.ing.interview.kata.consumer.contract.dao.TransactionDao;
import fr.ing.interview.kata.model.bean.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Business class that communicates with the {@link TransactionDao}
 */
@Service("transactionManager")
public class TransactionManagerImpl extends AbstractManager implements TransactionManager {

    @Override
    public List<Transaction> getTransactionsListByAccount(String accountNumber) {
        TransactionDao transactionDao = getDaoFactory().getTransactionDao();
        List<Transaction> listOfTransactions = transactionDao.getTransactionsListByAccount(accountNumber);
        return listOfTransactions;
    }

    @Override
    public void createTransaction(String accountNumber, double amount) {
        TransactionDao transactionDao = getDaoFactory().getTransactionDao();
        transactionDao.createTransaction(accountNumber, amount);
    }
}
