package fr.ing.interview.kata.model.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A user of the application
 */
public class User {

    private Integer userId;

    private String login;
    private String password;

    private List<Account> accountsList = new ArrayList<>();

    //--------------------- METHODS ---------------------//
    public void addAccount(Account account) {
        accountsList.add(account);
    }

    //----------------- GETTERS/SETTERS -----------------//
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Account> getAccountsList() {
        return accountsList;
    }

    public void setAccountsList(List<Account> accountsList) {
        this.accountsList = accountsList;
    }
}
