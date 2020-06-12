package fr.ing.interview.kata.business.impl.manager;

import fr.ing.interview.kata.consumer.contract.DaoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Abstract class that gives access to the {@link DaoFactory}
 */
@Service("abstractManager")
public abstract class AbstractManager {

    @Autowired
    private DaoFactory daoFactory;

    //----------------- GETTERS/SETTERS -----------------//
    protected DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
