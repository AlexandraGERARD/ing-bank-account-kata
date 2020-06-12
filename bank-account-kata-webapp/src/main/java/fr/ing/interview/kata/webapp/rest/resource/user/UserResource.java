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
    public void getUser(@FormParam("login") String login, @FormParam("password") String password) {
        try {
            User user = getSelectedUser(login, password);
            List<Account> userAccounts = getUserAccounts(user.getUserId());
            user.setAccountsList(userAccounts);

            putUserInSessionAndRedirect(user);
        } catch (ServletException | IOException | NotFoundException | TooManyResultsException e) {
        }
    }

    private User getSelectedUser(String login, String password) throws NotFoundException, TooManyResultsException {
        UserManager userManager = getManagerFactory().getUserManager();
        User user = userManager.getUser(login, password);

        return user;
    }

    private List<Account> getUserAccounts(Integer id) {
        AccountManager accountManager = getManagerFactory().getAccountManager();
        List<Account> userAccounts = accountManager.getAccountsListByUser(id);

        return userAccounts;
    }

    private void putUserInSessionAndRedirect(User user) throws ServletException, IOException {
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
