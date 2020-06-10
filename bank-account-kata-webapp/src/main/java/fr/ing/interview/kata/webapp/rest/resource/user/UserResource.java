package fr.ing.interview.kata.webapp.rest.resource.user;

import fr.ing.interview.kata.business.contract.manager.UserManager;
import fr.ing.interview.kata.model.bean.User;
import fr.ing.interview.kata.model.exception.NotFoundException;
import fr.ing.interview.kata.webapp.rest.resource.AbstractResource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * REST resource for the {@link User}.
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource extends AbstractResource {

    @POST
    @Path("user")
    public User get(@FormParam("login") String login, @FormParam("password") String password) {
        UserManager userManager = getManagerFactory().getUserManager();
        User user = userManager.getUser(login, password);
        return user;
    }
}
