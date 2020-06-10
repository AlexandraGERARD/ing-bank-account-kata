package fr.ing.interview.kata.webapp.rest.resource.account;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.ing.interview.kata.business.contract.manager.AccountManager;
import fr.ing.interview.kata.model.bean.Account;
import fr.ing.interview.kata.webapp.rest.resource.AbstractResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * REST resource for the {@link Account}.
 */
@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource extends AbstractResource {

    @GET
    @Path("{id}")
    //public Account get(@PathParam("id") Integer pId) throws NotFoundException {
    public Account get(@PathParam("id") String pId) {
        AccountManager accountManager = getManagerFactory().getAccountManager();
        Account account = accountManager.getAccount(pId);
        return account;
    }

    @GET
    public List<String> get() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        AccountManager accountManager = getManagerFactory().getAccountManager();
        List<Account> accountsList = accountManager.getAccountsList();
        List<String> result = new ArrayList<>();

        for(Account a : accountsList){
            result.add(mapper.writeValueAsString(a));
        }
        return result;
        //return "test";
        //List<String> s = new ArrayList<>();
        //s.add("a");
        //s.add("b");

        //return s;
    }
}
