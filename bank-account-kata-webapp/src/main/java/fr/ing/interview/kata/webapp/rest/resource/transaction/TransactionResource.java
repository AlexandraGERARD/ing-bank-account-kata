package fr.ing.interview.kata.webapp.rest.resource.transaction;

import fr.ing.interview.kata.business.contract.manager.AccountManager;
import fr.ing.interview.kata.business.contract.manager.TransactionManager;
import fr.ing.interview.kata.model.bean.Account;
import fr.ing.interview.kata.model.bean.Transaction;
import fr.ing.interview.kata.model.exception.NotFoundException;
import fr.ing.interview.kata.model.exception.TooManyResultsException;
import fr.ing.interview.kata.webapp.rest.resource.AbstractResource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

/**
 * REST resource for the {@link Transaction}.
 */
@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource extends AbstractResource {

    @GET
    @Path("list/{accountNumber}")
    public void getList(@PathParam("accountNumber") String accountNumber) throws ServletException, IOException{
        TransactionManager transactionManager = getManagerFactory().getTransactionManager();

        List<Transaction> accountTransactions = transactionManager.getTransactionsListByAccount(accountNumber);

        ServletContext context = getContext();
        RequestDispatcher rd = context.getRequestDispatcher("/transactionHistory.jsp");

        HttpServletRequest request = getRequest();
        HttpSession session = request.getSession();
        session.setAttribute("transactions", accountTransactions);

        rd.forward(request, getResponse());
    }

    @GET
    @Path("addWithdraw/{accountNumber}")
    public void addOrWithdraw(@PathParam("accountNumber") String accountNumber) throws ServletException, IOException {
        ServletContext context = getContext();
        RequestDispatcher rd = context.getRequestDispatcher("/addWithdrawMoney.jsp");
        rd.forward(getRequest(), getResponse());
    }
}
