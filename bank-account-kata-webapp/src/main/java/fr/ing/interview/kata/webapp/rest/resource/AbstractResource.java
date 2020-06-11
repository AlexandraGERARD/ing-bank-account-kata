package fr.ing.interview.kata.webapp.rest.resource;

import fr.ing.interview.kata.business.impl.ManagerFactoryImpl;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

/**
 * Abstract class that gives access to the {@link ManagerFactoryImpl}
 */
public abstract class AbstractResource{

    @Context
    private HttpServletRequest request;

    @Context
    private HttpServletResponse response;

    @Context
    private ServletContext context;

    private static ManagerFactoryImpl managerFactory;

    //----------------- GETTERS/SETTERS -----------------//
    protected static ManagerFactoryImpl getManagerFactory() {
        return managerFactory;
    }

    public static void setManagerFactory(ManagerFactoryImpl managerFactory) {
        AbstractResource.managerFactory = managerFactory;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public ServletContext getContext() {
        return context;
    }
}
