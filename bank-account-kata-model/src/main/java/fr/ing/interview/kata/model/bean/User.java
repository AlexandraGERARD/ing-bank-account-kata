package fr.ing.interview.kata.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

/**
 * A user of the application
 */
@Entity(name = "USER")
public class User {

    @Id
    private String id;

    @Column(name="LOGIN")
    private String login;

    @Column(name="PASSWORD")
    private String password;

    private Set<Account> accountsSet = new HashSet<>();

    //----------------- METHODS -----------------//
    public void addAccount(Account account) {
        accountsSet.add(account);
    }

    //----------------- GETTERS/SETTERS -----------------//
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Account> getAccountsSet() {
        return accountsSet;
    }
}
