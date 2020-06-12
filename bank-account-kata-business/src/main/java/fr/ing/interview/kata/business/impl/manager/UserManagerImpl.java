package fr.ing.interview.kata.business.impl.manager;

import fr.ing.interview.kata.business.contract.manager.UserManager;
import fr.ing.interview.kata.consumer.contract.dao.UserDao;
import fr.ing.interview.kata.model.bean.User;
import fr.ing.interview.kata.model.exception.NotFoundException;
import fr.ing.interview.kata.model.exception.TooManyResultsException;
import org.springframework.stereotype.Service;

/**
 * Business class that communicates with the {@link UserDao}
 */
@Service("userManager")
public class UserManagerImpl extends AbstractManager implements UserManager {

    @Override
    public User getUser(String login, String password) throws NotFoundException, TooManyResultsException {
        UserDao userDao = getDaoFactory().getUserDao();

        User user = userDao.getByLoginAndPassword(login, password);
        return user;
    }
}
