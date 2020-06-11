package fr.ing.interview.kata.model.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * The bank account of a user
 */
public class Account {

    private Double balance = 0.00;

    private Integer userId;

    private List<Transaction> transactionsList = new ArrayList<>();

    private String accountNumber;

    //----------------- GETTERS/SETTERS -----------------//
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Transaction> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<Transaction> transactionsList) {
        this.transactionsList = transactionsList;
    }
}
