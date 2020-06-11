package fr.ing.interview.kata.webapp.rest.resource.user;

import fr.ing.interview.kata.business.contract.manager.AccountManager;
import fr.ing.interview.kata.business.contract.manager.UserManager;
import fr.ing.interview.kata.model.bean.Account;
import fr.ing.interview.kata.model.bean.User;
import fr.ing.interview.kata.model.exception.NotFoundException;
import fr.ing.interview.kata.model.exception.TooManyResultsException;
import fr.ing.interview.kata.webapp.rest.resource.AbstractResource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

/**
 * REST resource for the {@link User}.
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource extends AbstractResource {

    @POST
    @Path("/login")
    public void get(@FormParam("login") String login, @FormParam("password") String password) throws ServletException, IOException, NotFoundException, TooManyResultsException {
        UserManager userManager = getManagerFactory().getUserManager();
        AccountManager accountManager = getManagerFactory().getAccountManager();

        User user = userManager.getUser(login, password);
        List<Account> userAccounts = accountManager.getAccountsListByUser(user.getUserId());
        user.setAccountsList(userAccounts);

        HttpServletResponse response = getResponse();
        getResponse().setHeader("Access-Control-Allow-Credentials", "true");

        ServletContext context = getContext();
        RequestDispatcher rd = context.getRequestDispatcher("/menu.jsp");

        HttpServletRequest request = getRequest();
        HttpSession session = request.getSession();
        session.setAttribute("selectedUser", user);

        rd.forward(request, response);
    }
}
