package fr.ing.interview.kata.consumer.impl;

import fr.ing.interview.kata.consumer.contract.DaoFactory;
import fr.ing.interview.kata.consumer.contract.dao.AccountDao;
import fr.ing.interview.kata.consumer.contract.dao.TransactionDao;
import fr.ing.interview.kata.consumer.contract.dao.UserDao;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Class that gives access to the different DAO interfaces {@link AccountDao}, {@link TransactionDao} and {@link UserDao}
 */
@Named("daoFactory")
public class DaoFactoryImpl implements DaoFactory {

    @Inject
    private AccountDao accountDao;

    @Inject
    private TransactionDao transactionDao;

    @Inject
    private UserDao userDao;

    //----------------- GETTERS/SETTERS -----------------//
    @Override
    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public TransactionDao getTransactionDao() {
        return transactionDao;
    }

    public void setTransactionDao(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    @Override
    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
