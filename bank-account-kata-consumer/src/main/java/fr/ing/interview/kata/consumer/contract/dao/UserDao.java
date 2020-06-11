package fr.ing.interview.kata.consumer.contract.dao;

import fr.ing.interview.kata.consumer.impl.dao.UserDaoImpl;
import fr.ing.interview.kata.model.bean.User;
import fr.ing.interview.kata.model.exception.NotFoundException;
import fr.ing.interview.kata.model.exception.TooManyResultsException;

/**
 * Interface of the class {@link UserDaoImpl}
 */
public interface UserDao {

    User getByLoginAndPassword(String login, String password) throws NotFoundException, TooManyResultsException;
}
