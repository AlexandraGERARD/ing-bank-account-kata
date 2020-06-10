package fr.ing.interview.kata.consumer.impl.dao;

import fr.ing.interview.kata.consumer.contract.dao.TransactionDao;

import javax.inject.Named;

/**
 * Class that communicates with the database (table TRANSACTION)
 */
@Named
public class TransactionDaoImpl extends AbstractDaoImpl implements TransactionDao {
}
