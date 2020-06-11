package fr.ing.interview.kata.webapp.rest.resource.account;

import fr.ing.interview.kata.business.contract.manager.AccountManager;
import fr.ing.interview.kata.model.bean.Account;
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

/**
 * REST resource for the {@link Account}.
 */
@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource extends AbstractResource {

    @GET
    @Path("{accountNumber}")
    public void getAccount(@PathParam("accountNumber") String accountNumber) {
        Account account = getSelectedAccount(accountNumber);
        putAccountInSessionAndRedirect(account);
    }

    private Account getSelectedAccount(String accountNumber) {
        try {
            AccountManager accountManager = getManagerFactory().getAccountManager();
            Account account = accountManager.getAccountByNumber(accountNumber);

            return account;
        } catch (NotFoundException | TooManyResultsException e) {
            return null;
        }
    }

    private void putAccountInSessionAndRedirect(Account account) {
        try {
            ServletContext context = getContext();
            RequestDispatcher rd = context.getRequestDispatcher("/account.jsp");

            HttpServletRequest request = getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("selectedAccount", account);

            rd.forward(request, getResponse());
        } catch (ServletException | IOException e) {
        }
    }
}
