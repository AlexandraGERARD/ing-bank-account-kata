package fr.ing.interview.kata.consumer.impl;

import fr.ing.interview.kata.consumer.contract.DaoFactory;
import fr.ing.interview.kata.consumer.contract.dao.AccountDao;
import fr.ing.interview.kata.consumer.contract.dao.TransactionDao;
import fr.ing.interview.kata.consumer.contract.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class that gives access to the different DAO interfaces: {@link AccountDao}, {@link TransactionDao} and {@link UserDao}
 */
@Component("daoFactory")
public class DaoFactoryImpl implements DaoFactory {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
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
