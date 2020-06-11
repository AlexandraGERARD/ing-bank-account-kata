package fr.ing.interview.kata.business.impl.manager;

import fr.ing.interview.kata.business.contract.manager.TransactionManager;
import fr.ing.interview.kata.consumer.contract.dao.TransactionDao;

import javax.inject.Named;

/**
 * Business class that communicates with the {@link TransactionDao}
 */
@Named("transactionManager")
public class TransactionManagerImpl extends AbstractManager implements TransactionManager {
}
