package fr.ing.interview.kata.business.impl.manager;

import fr.ing.interview.kata.business.contract.manager.UserManager;
import fr.ing.interview.kata.consumer.contract.dao.UserDao;
import fr.ing.interview.kata.model.bean.User;

import javax.inject.Named;

@Named("userManager")
public class UserManagerImpl extends AbstractManager implements UserManager {

    @Override
    public User getUser(String login, String password) {
        UserDao userDao = getDaoFactory().getUserDao();

        User user = userDao.getByLoginAndPassword(login, password);

        return user;
    }
}
