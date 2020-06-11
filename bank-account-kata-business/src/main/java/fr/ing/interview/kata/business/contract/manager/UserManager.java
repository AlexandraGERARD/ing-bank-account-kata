package fr.ing.interview.kata.business.contract.manager;

import fr.ing.interview.kata.business.impl.manager.UserManagerImpl;
import fr.ing.interview.kata.model.bean.User;
import fr.ing.interview.kata.model.exception.NotFoundException;
import fr.ing.interview.kata.model.exception.TooManyResultsException;

/**
 * Interface of the class {@link UserManagerImpl}
 */
public interface UserManager {

    User getUser(String login, String password) throws NotFoundException, TooManyResultsException;
}
