package com.esolutions.trainings.jsc2.req2;

import com.esolutions.trainings.jsc2.Config;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Tests {
	private static final String RESOURCE = "/floors/%s/rooms/%s/book";
	private RestTemplate restTemplate;

	@Before
	public void setUp() {
		this.restTemplate = new RestTemplate();
		this.restTemplate.setInterceptors(Collections.singletonList(new ClientHttpRequestInterceptor() {
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
				System.out.println(new String(body, Charset.defaultCharset()));
				return execution.execute(request, body);
			}
		}));
	}

	@Test
	public void req2_book_f1_r1_1d() {
		final int floor = 1;
		final int room = 1;
		final LocalDate today = LocalDate.now();
		final LocalDate tomorrow = LocalDate.now().plus(1, ChronoUnit.DAYS);

		//Expected
		final BigDecimal expectedPrice = new Book(today, tomorrow, floor, room).price();

		//Actual
		BookReq request = new BookReq(today, tomorrow);
		final ResponseEntity<BookRes> resp =
				restTemplate.postForEntity(Config.BASE_URL.concat(String.format(RESOURCE, 1, 1)), request, BookRes.class);

		assertThat(resp.getStatusCode(), is(HttpStatus.OK));
		final BookRes respBody = resp.getBody();
		assertThat(respBody, is(notNullValue()));
		assertThat(respBody.getBooked(), is(true));
		assertThat(respBody.getPrice(), is(expectedPrice));
	}
}
