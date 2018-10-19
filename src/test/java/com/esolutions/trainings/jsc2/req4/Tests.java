package com.esolutions.trainings.jsc2.req4;

import com.esolutions.trainings.jsc2.Config;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Tests {

    private static final String RESOURCE = "/floors/%s/rooms/%s/wifi/password";
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        this.restTemplate = new RestTemplate();
    }

    @Test
    public void req4_f1_1_r1_1() {
        ResponseEntity<PasswordResponse> response = restTemplate.getForEntity(Config.BASE_URL.concat(String.format(RESOURCE, 1, 1)), PasswordResponse.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        final PasswordResponse respBody = response.getBody();
        assertThat(respBody, is(notNullValue()));
        assertThat(respBody.getPassword(), is("PASS-1-1-1"));
    }

    @Test
    public void req4_f1_10_r1_15() {
        ResponseEntity<PasswordResponse> response = restTemplate.getForEntity(Config.BASE_URL.concat(String.format(RESOURCE, 10, 15)), PasswordResponse.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        final PasswordResponse respBody = response.getBody();
        assertThat(respBody, is(notNullValue()));
        assertThat(respBody.getPassword(), is("PASS-10-15-2796203"));
    }

    @Test
    public void req4_f1_7_r1_13() {
        ResponseEntity<PasswordResponse> response = restTemplate.getForEntity(Config.BASE_URL.concat(String.format(RESOURCE, 7, 13)), PasswordResponse.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        final PasswordResponse respBody = response.getBody();
        assertThat(respBody, is(notNullValue()));
        assertThat(respBody.getPassword(), is("PASS-7-13-87382"));
    }

    @Test
    public void req4_f1_9_r1_14() {
        ResponseEntity<PasswordResponse> response = restTemplate.getForEntity(Config.BASE_URL.concat(String.format(RESOURCE, 9, 14)), PasswordResponse.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        final PasswordResponse respBody = response.getBody();
        assertThat(respBody, is(notNullValue()));
        assertThat(respBody.getPassword(), is("PASS-9-14-699050"));
    }

    @Test
    public void req4_f1_4_r1_6() {
        ResponseEntity<PasswordResponse> response = restTemplate.getForEntity(Config.BASE_URL.concat(String.format(RESOURCE, 4, 6)), PasswordResponse.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        final PasswordResponse respBody = response.getBody();
        assertThat(respBody, is(notNullValue()));
        assertThat(respBody.getPassword(), is("PASS-4-6-85"));
    }
}
