package com.esolutions.trainings.jsc2.req5;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.esolutions.trainings.jsc2.Config.BASE_URL;
import static java.util.Collections.emptyList;
import static junit.framework.TestCase.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Tests {
    private static final List<String> EXPECTED_REQ2;

    private static final String RESOURCE = "/guests/last-name/repeated";
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        this.restTemplate = new RestTemplate();
    }

    static {
        EXPECTED_REQ2 = new ArrayList<>();
        EXPECTED_REQ2.add("Acosta");
        EXPECTED_REQ2.add("Aguilar");
        EXPECTED_REQ2.add("Alarcón");
        EXPECTED_REQ2.add("Camarena");
        EXPECTED_REQ2.add("Gaspar");
        EXPECTED_REQ2.add("Gastan");
        EXPECTED_REQ2.add("Morelos");
        EXPECTED_REQ2.add("Pedrosa");
        EXPECTED_REQ2.add("Teyo");
        EXPECTED_REQ2.add("Álvarez");
    }

    @Test
    public void req_5() {
        final RepeatedLastNameModel response = restTemplate.getForObject(BASE_URL.concat(RESOURCE), RepeatedLastNameModel.class);

        final List<String> actualResponse = response.getLastNames() != null ? response.getLastNames() : emptyList();

        boolean pass = true;
        for (String actual : actualResponse) {
            if (!EXPECTED_REQ2.contains(actual)) {
                System.out.println("Actual '" + actual + "' is not repeated");
                pass = false;
            }
        }

        for (String expected : EXPECTED_REQ2) {
            if (!actualResponse.contains(expected)) {
                System.out.println("Expected '" + expected + "' is not in response");
                pass = false;
            }
        }

        if (!pass) {
            fail();
        }
    }


}
