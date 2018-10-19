package com.esolutions.trainings.jsc2.req3;

import com.esolutions.trainings.jsc2.Config;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class
Tests {
    private static final String RESOURCE = "/floors/%s/rooms/%s/wifi/ssid";
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        this.restTemplate = new RestTemplate();
    }

    @Test
    public void req3_f1_1_r1_1() {
        ResponseEntity<SSidResponse> response = restTemplate.getForEntity(Config.BASE_URL.concat(String.format(RESOURCE, 1, 1)), SSidResponse.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        final SSidResponse respBody = response.getBody();
        assertThat(respBody, is(notNullValue()));
        assertThat(respBody.getSsid(), is("HAND-1-1"));
    }

    @Test
    public void req3_f1_10_r1_15() {
        ResponseEntity<SSidResponse> response = restTemplate.getForEntity(Config.BASE_URL.concat(String.format(RESOURCE, 10, 15)), SSidResponse.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        final SSidResponse respBody = response.getBody();
        assertThat(respBody, is(notNullValue()));
        assertThat(respBody.getSsid(), is("HAND-10-15-1"));
    }

    @Test
    public void req3_f1_105_r1_145() {
        ResponseEntity<SSidResponse> response = restTemplate.getForEntity(Config.BASE_URL.concat(String.format(RESOURCE, 105, 145)), SSidResponse.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        final SSidResponse respBody = response.getBody();
        assertThat(respBody, is(notNullValue()));
        assertThat(respBody.getSsid(), is("HAND-105-145-3"));
    }

    @Test
    public void req3_f1_33_r1_230() {
        ResponseEntity<SSidResponse> response = restTemplate.getForEntity(Config.BASE_URL.concat(String.format(RESOURCE, 33, 230)), SSidResponse.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        final SSidResponse respBody = response.getBody();
        assertThat(respBody, is(notNullValue()));
        assertThat(respBody.getSsid(), is("HAND-33-230-4"));
    }

    @Test
    public void req3_f1_65_r1_129() {
        ResponseEntity<SSidResponse> response = restTemplate.getForEntity(Config.BASE_URL.concat(String.format(RESOURCE, 65, 129)), SSidResponse.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        final SSidResponse respBody = response.getBody();
        assertThat(respBody, is(notNullValue()));
        assertThat(respBody.getSsid(), is("HAND-65-129-6"));
    }

    @Test
    public void req3_f1_257_r1_290() {
        ResponseEntity<SSidResponse> response = restTemplate.getForEntity(Config.BASE_URL.concat(String.format(RESOURCE, 257, 290)), SSidResponse.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        final SSidResponse respBody = response.getBody();
        assertThat(respBody, is(notNullValue()));
        assertThat(respBody.getSsid(), is("HAND-257-290-7"));
    }
}
