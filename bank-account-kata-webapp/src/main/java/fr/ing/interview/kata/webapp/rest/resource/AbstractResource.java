package fr.ing.interview.kata.webapp.rest.resource;

import fr.ing.interview.kata.business.impl.ManagerFactoryImpl;

/**
 * Abstract class that gives access to the factories
 */
public abstract class AbstractResource {

    private static ManagerFactoryImpl managerFactory;

    protected static ManagerFactoryImpl getManagerFactory() {
        return managerFactory;
    }

    public static void setManagerFactory(ManagerFactoryImpl managerFactory) {
        AbstractResource.managerFactory = managerFactory;
    }
}
