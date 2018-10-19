package com.esolutions.trainings.jsc2.req2;

import com.esolutions.trainings.jsc2.Config;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Tests {
	private static final String RESOURCE = "/floors/%s/rooms/%s/book";
	private RestTemplate restTemplate;
	private static Set<Room> bookedRooms = new HashSet<>();

	@Before
	public void setUp() {
		this.restTemplate = new RestTemplate();
		this.restTemplate.setInterceptors(Collections.singletonList((request, body, execution) -> {
			System.out.println(new String(body, Charset.defaultCharset()));
			return execution.execute(request, body);
		}));
	}

	@Test
	public void x() {
		System.out.println();
	}

	@Test
	public void req2_book_1d_standard() {
		final Room room = Rooms.roomsByFloorAndRoom.get(1).get(1);
		if (bookedRooms.contains(room)) {
			fail("Habitacion reservada previamente");
		}
		final LocalDate today = LocalDate.now();
		final LocalDate tomorrow = LocalDate.now().plus(1, ChronoUnit.DAYS);

		//Actual
		_assert(room, today, tomorrow, true);
	}

	@Test
	public void req2_book_1d_suite() {
		final Room room = Rooms.roomsByFloorAndRoom.get(1).get(11);
		if (bookedRooms.contains(room)) {
			fail("Habitacion reservada previamente");
		}
		final LocalDate today = LocalDate.now();
		final LocalDate tomorrow = LocalDate.now().plus(1, ChronoUnit.DAYS);

		_assert(room, today, tomorrow, true);
	}

	@Test
	public void book_1w_standard() {
		final Room room = Rooms.roomsByFloorAndRoom.get(1).get(2);
		if (bookedRooms.contains(room)) {
			fail("Habitacion reservada previamente");
		}

		final LocalDate monday = LocalDate.now().with(DayOfWeek.MONDAY);
		final LocalDate sunday = LocalDate.now().with(DayOfWeek.SUNDAY);

		_assert(room, monday, sunday, true);
	}

	private void _assert(Room room, LocalDate checkIn, LocalDate checkOut, boolean shouldBeBooked) {
		//Expected
		final BigDecimal expectedPrice = new Book(checkIn, checkOut, room.getFloor(), room.getRoom()).price();

		//Actual
		BookReq request = new BookReq(checkIn, checkOut);
		final String url = Config.BASE_URL.concat(String.format(RESOURCE, room.getFloor(), room.getRoom()));

		final ResponseEntity<BookRes> resp = restTemplate.postForEntity(url, request, BookRes.class);
		final BookRes respBody = resp.getBody();

		assertThat(resp.getStatusCode(), is(HttpStatus.OK));
		bookedRooms.add(room);
		assertThat(respBody, is(notNullValue()));
		assertThat(respBody.getBooked(), is(shouldBeBooked));
		assertThat(respBody.getPrice(), is(expectedPrice));
	}
}
