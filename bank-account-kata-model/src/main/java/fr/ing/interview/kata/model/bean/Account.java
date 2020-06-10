package fr.ing.interview.kata.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The bank account of a user
 */
@Entity(name = "ACCOUNT")
public class Account {

    @Id
    private String accountNumber;

    @Column(name="BALANCE")
    private Double balance = 0.00;

    //----------------- METHODS -----------------//
    public Account() {
    }

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    //----------------- GETTERS/SETTERS -----------------//
    public Double getBalance() {
        return balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
