package fr.ing.interview.kata.business.contract.manager;

import fr.ing.interview.kata.model.bean.Account;

import java.util.List;

public interface AccountManager {

    Account getAccount(String pId);

    List<Account> getAccountsList();
}
