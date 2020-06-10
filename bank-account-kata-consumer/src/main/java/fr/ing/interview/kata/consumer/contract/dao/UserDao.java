package fr.ing.interview.kata.consumer.contract.dao;

import fr.ing.interview.kata.model.bean.User;

public interface UserDao {

    User getByLoginAndPassword(String login, String password);
}
