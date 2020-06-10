package fr.ing.interview.kata.business.impl.manager;

import fr.ing.interview.kata.consumer.contract.DaoFactory;

public abstract class AbstractManager {

    private DaoFactory daoFactory;

    protected DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
