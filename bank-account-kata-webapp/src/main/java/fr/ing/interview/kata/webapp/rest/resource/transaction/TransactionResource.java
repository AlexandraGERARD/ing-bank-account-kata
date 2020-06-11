package fr.ing.interview.kata.webapp.rest.resource.transaction;

import fr.ing.interview.kata.business.contract.manager.AccountManager;
import fr.ing.interview.kata.business.contract.manager.TransactionManager;
import fr.ing.interview.kata.model.bean.Account;
import fr.ing.interview.kata.model.bean.Transaction;
import fr.ing.interview.kata.webapp.rest.resource.AbstractResource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * REST resource for the {@link Transaction}.
 */
@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource extends AbstractResource {

    @GET
    @Path("list/{accountNumber}")
    public void getList(@PathParam("accountNumber") String accountNumber) {
        try {
            TransactionManager transactionManager = getManagerFactory().getTransactionManager();

            List<Transaction> accountTransactions = transactionManager.getTransactionsListByAccount(accountNumber);

            ServletContext context = getContext();
            RequestDispatcher rd = context.getRequestDispatcher("/transactionHistory.jsp");

            HttpServletRequest request = getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("transactions", accountTransactions);

            rd.forward(request, getResponse());
        } catch (ServletException | IOException e) {
        }
    }

    @GET
    @Path("addWithdraw/{accountNumber}")
    public void addOrWithdraw(@PathParam("accountNumber") String accountNumber) {
        try {
            ServletContext context = getContext();
            RequestDispatcher rd = context.getRequestDispatcher("/addWithdrawMoney.jsp");
            rd.forward(getRequest(), getResponse());
        } catch (ServletException | IOException e) {
        }
    }

    @POST
    @Path("addWithdraw/add")
    public String add(@FormParam("amount") double amount) {
        if (amount > 0.01) {
            Account account = getSelectedAccount();
            createTransactionAndUpdateBalance(account, amount);

            return null;
        }

        return "montant invalide";
    }

    @POST
    @Path("addWithdraw/withdraw")
    public void withdraw(@FormParam("amount") double amount) {
        Account account = getSelectedAccount();

        if (isNotOverdraft(account.getBalance(), amount)) {
            double amountAsWithdraw = convertPositiveIntoNegative(amount);
            createTransactionAndUpdateBalance(account, amountAsWithdraw);
        }
    }

    private Account getSelectedAccount() {
        HttpServletRequest request = getRequest();
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("selectedAccount");

        return account;
    }

    private void createTransactionAndUpdateBalance(Account account, double amount) {
        String accountNumber = account.getAccountNumber();

        createTransaction(accountNumber, amount);

        double newBalance = calculateNewBalance(account.getBalance(),amount);
        updateAccountBalance(accountNumber, newBalance);

        account.setBalance(newBalance);
        addOrWithdraw(account.getAccountNumber());
    }

    private void createTransaction(String accountNumber, double amount) {
        TransactionManager transactionManager = getManagerFactory().getTransactionManager();
        transactionManager.createTransaction(accountNumber, amount);
    }

    private void updateAccountBalance(String accountNumber, double balance) {
        AccountManager accountManager = getManagerFactory().getAccountManager();
        accountManager.updateBalance(accountNumber, balance);
    }

    private boolean isNotOverdraft(double balanceBeforeWithdraw, double withdraw) {
        return balanceBeforeWithdraw - withdraw >= 0;
    }

    private double convertPositiveIntoNegative(double amount) {
        double negativeNumber = amount * (-1);

        return negativeNumber;
    }

    private double calculateNewBalance(double initialBalance, double amount){
        BigDecimal initialBalanceAsBigDecimal = new BigDecimal(initialBalance);
        BigDecimal amountAsBigDecimal = new BigDecimal(amount);
        BigDecimal newBalanceAsBigDecimal = initialBalanceAsBigDecimal.add(amountAsBigDecimal);

        return newBalanceAsBigDecimal.doubleValue();
    }
}
