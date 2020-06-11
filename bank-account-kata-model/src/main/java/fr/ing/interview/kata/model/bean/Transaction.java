package fr.ing.interview.kata.model.bean;

import java.util.Date;

/**
 * A transaction initiated by a user
 */
public class Transaction {

    private Date date;

    private Double amount;

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }
}
