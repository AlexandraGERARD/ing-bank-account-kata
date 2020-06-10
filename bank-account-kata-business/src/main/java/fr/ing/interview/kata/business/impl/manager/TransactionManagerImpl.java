package fr.ing.interview.kata.business.impl.manager;

import fr.ing.interview.kata.business.contract.manager.TransactionManager;

import javax.inject.Named;

@Named("transactionManager")
public class TransactionManagerImpl extends AbstractManager implements TransactionManager {
}
