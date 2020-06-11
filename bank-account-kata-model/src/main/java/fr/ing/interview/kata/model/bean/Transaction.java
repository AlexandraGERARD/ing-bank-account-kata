package fr.ing.interview.kata.model.bean;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * A transaction initiated by a user
 */
public class Transaction {

    private Date date;

    private double amount;

    private Integer transactionId;

    private String accountNumber;

    //----------------- GETTERS/SETTERS -----------------//
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }
}
