package com.esolutions.trainings.jsc2.req1;

import com.esolutions.trainings.jsc2.Config;
import com.esolutions.trainings.jsc2.req3.SSidResponse;
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

    private static final String RESOURCE = "/floors/%s/rooms/%s";
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        this.restTemplate = new RestTemplate();
    }

    @Test
    public void req_1_f_259_r_24_is_39492(){
        ResponseEntity<GuestResponse> response = restTemplate.getForEntity(Config.BASE_URL.concat(String.format(RESOURCE,259,24)), GuestResponse.class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        final GuestResponse respBody = response.getBody();
        assertThat(respBody, is(notNullValue()));
        assertThat(respBody.getGuest(), is(39492));
    }

    @Test
    public void req_1_f_60_r_11_is_2455(){
        ResponseEntity<GuestResponse> response = restTemplate.getForEntity(Config.BASE_URL.concat(String.format(RESOURCE,259,24)), GuestResponse.class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        final GuestResponse respBody = response.getBody();
        assertThat(respBody, is(notNullValue()));
        assertThat(respBody.getGuest(), is(2455));
    }

    @Test
    public void req_1_f_3_r_2_is_5(){
        ResponseEntity<GuestResponse> response = restTemplate.getForEntity(Config.BASE_URL.concat(String.format(RESOURCE,259,24)), GuestResponse.class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        final GuestResponse respBody = response.getBody();
        assertThat(respBody, is(notNullValue()));
        assertThat(respBody.getGuest(), is(5));
    }

}
