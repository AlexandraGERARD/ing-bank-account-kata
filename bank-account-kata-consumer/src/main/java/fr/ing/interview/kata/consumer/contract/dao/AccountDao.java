package fr.ing.interview.kata.consumer.contract.dao;

import fr.ing.interview.kata.model.bean.Account;
import fr.ing.interview.kata.model.exception.NotFoundException;
import fr.ing.interview.kata.model.exception.TooManyResultsException;

import java.util.List;

public interface AccountDao {

    List<Account> getAccountsListByUser(Integer userId);

    Account getAccountByNumber(String accountNumber) throws NotFoundException, TooManyResultsException;
}
