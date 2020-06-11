package fr.ing.interview.kata.webapp.rest.resource.transaction;

import fr.ing.interview.kata.business.contract.manager.UserManager;
import fr.ing.interview.kata.model.bean.Transaction;
import fr.ing.interview.kata.model.bean.User;
import fr.ing.interview.kata.webapp.rest.resource.AbstractResource;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST resource for the {@link Transaction}.
 */
@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource extends AbstractResource {

    @GET
    public String get() {
        return "blaba";
    }
}
