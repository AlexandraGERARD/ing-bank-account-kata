package fr.ing.interview.kata.business.contract.manager;

import fr.ing.interview.kata.model.bean.User;

public interface UserManager {

    User getUser(String login, String password);
}
