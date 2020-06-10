package fr.ing.interview.kata.model.test;

import fr.ing.interview.kata.model.bean.Account;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    public void test_the_amount_of_a_new_account_is_equal_to_0(){
        Double expectedBalance = 0.00;

        Account account = new Account();

        Assertions.assertThat(account.getBalance()).isEqualTo(expectedBalance);
    }
}
