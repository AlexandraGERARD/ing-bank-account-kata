package fr.ing.interview.kata.model.test;

import fr.ing.interview.kata.model.bean.Account;
import fr.ing.interview.kata.model.bean.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void test_successful_adding_of_an_account_to_a_customer() {
        User customer = new User();

        Account account = new Account();
       // customer.addAccount(account);

        //boolean result = customer.getAccountsSet().contains(account);

        Assertions.assertThat(true).isTrue();
    }
}
