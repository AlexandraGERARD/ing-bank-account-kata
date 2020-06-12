package fr.ing.interview.kata.webapp.rest.resource;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AccountResourceTest {

    @Test
    public void test_get_account_ok() throws IOException {
        String accountNumber = "FR7630001007941234567890185";

        HttpUriRequest request = new HttpGet("http://localhost:8080/bank-account-kata-webapp/rest/account/" + accountNumber);

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        Assertions.assertThat(
                httpResponse.getStatusLine().getStatusCode()).isEqualTo(HttpStatus.SC_NO_CONTENT);
    }

    @Test
    public void test_get_account_ko() throws IOException {
        String accountNumber = "1";

        HttpUriRequest request = new HttpGet("http://localhost:8080/bank-account-kata-webapp/rest/account/" + accountNumber);

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        Assertions.assertThat(
                httpResponse.getStatusLine().getStatusCode()).isEqualTo(HttpStatus.SC_NOT_FOUND);
    }
}
