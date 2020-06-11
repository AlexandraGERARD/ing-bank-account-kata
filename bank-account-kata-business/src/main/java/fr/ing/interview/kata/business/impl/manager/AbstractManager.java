package fr.ing.interview.kata.business.impl.manager;

import fr.ing.interview.kata.consumer.contract.DaoFactory;

/**
 * Abstract class that gives access to the {@link DaoFactory}
 */
public abstract class AbstractManager {

    private DaoFactory daoFactory;

    //----------------- GETTERS/SETTERS -----------------//
    protected DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
