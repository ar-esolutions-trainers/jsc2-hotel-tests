package com.esolutions.trainings.jsc2.req2;

import com.esolutions.trainings.jsc2.Config;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestsReq2 {
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
	public void _01_book_1d_standard_low() {
		final Room room = Rooms.roomsByFloorAndRoom.get(1).get(1);
		if (bookedRooms.contains(room)) {
			fail("Habitacion reservada previamente");
		}
		final LocalDate monday = LocalDate.now().with(DayOfWeek.MONDAY);
		final LocalDate thursday = LocalDate.now().with(DayOfWeek.THURSDAY);

		_assert_can_book(room, monday, thursday);
	}

	@Test
	public void _02_book_1d_standard_hi() {
		final Room room = Rooms.roomsByFloorAndRoom.get(1).get(2);
		if (bookedRooms.contains(room)) {
			fail("Habitacion reservada previamente");
		}
		final LocalDate friday = LocalDate.now().with(DayOfWeek.FRIDAY);
		final LocalDate saturday = LocalDate.now().with(DayOfWeek.SATURDAY);

		_assert_can_book(room, friday, saturday);
	}

	@Test
	public void _03_book_1d_suite_low() {
		final Room room = Rooms.roomsByFloorAndRoom.get(1).get(11);
		if (bookedRooms.contains(room)) {
			fail("Habitacion reservada previamente");
		}
		final LocalDate monday = LocalDate.now().with(DayOfWeek.MONDAY);
		final LocalDate thursday = LocalDate.now().with(DayOfWeek.THURSDAY);

		_assert_can_book(room, monday, thursday);
	}

	@Test
	public void _04_book_1d_suite_hi() {
		final Room room = Rooms.roomsByFloorAndRoom.get(1).get(18);
		if (bookedRooms.contains(room)) {
			fail("Habitacion reservada previamente");
		}
		final LocalDate friday = LocalDate.now().with(DayOfWeek.FRIDAY);
		final LocalDate saturday = LocalDate.now().with(DayOfWeek.SATURDAY);

		_assert_can_book(room, friday, saturday);
	}

	@Test
	public void _05_book_1w_standard() {
		final Room room = Rooms.roomsByFloorAndRoom.get(1).get(3);
		if (bookedRooms.contains(room)) {
			fail("Habitacion reservada previamente");
		}

		final LocalDate monday = LocalDate.now().with(DayOfWeek.MONDAY);
		final LocalDate sunday = LocalDate.now().with(DayOfWeek.SUNDAY);

		_assert_can_book(room, monday, sunday);
	}

	@Test
	public void _06_book_1w_suite() {
		final Room room = Rooms.roomsByFloorAndRoom.get(1).get(35);
		if (bookedRooms.contains(room)) {
			fail("Habitacion reservada previamente");
		}

		final LocalDate _2019_01_01 = LocalDate.of(2019, Month.JANUARY, 1);
		final LocalDate monday = _2019_01_01.with(DayOfWeek.MONDAY);
		final LocalDate sunday = _2019_01_01.with(DayOfWeek.SUNDAY);

		_assert_can_book(room, monday, sunday);
	}

	@Test
	public void _07_book_1m_standard() {
		final Room room = Rooms.roomsByFloorAndRoom.get(1).get(4);
		if (bookedRooms.contains(room)) {
			fail("Habitacion reservada previamente");
		}

		final LocalDate _2018_12_01 = LocalDate.of(2018, Month.DECEMBER, 1);
		final LocalDate _2018_12_31 = LocalDate.of(2018, Month.DECEMBER, 31);

		_assert_can_book(room, _2018_12_01, _2018_12_31);
	}

	@Test
	public void _08_book_1m_suite() {
		final Room room = Rooms.roomsByFloorAndRoom.get(1).get(36);
		if (bookedRooms.contains(room)) {
			fail("Habitacion reservada previamente");
		}

		final LocalDate _2018_12_01 = LocalDate.of(2018, Month.DECEMBER, 1);
		final LocalDate _2018_12_31 = LocalDate.of(2018, Month.DECEMBER, 31);

		_assert_can_book(room, _2018_12_01, _2018_12_31);
	}

	@Test
	public void _09_book_1d_standard_low_is_booked() {
		final Room room = Rooms.roomsByFloorAndRoom.get(1).get(1);

		final LocalDate monday = LocalDate.now().with(DayOfWeek.MONDAY);
		final LocalDate thursday = LocalDate.now().with(DayOfWeek.THURSDAY);

		//Actual
		_assert_cant_book(room, monday, thursday);
	}

	@Test
	public void _10_book_1d_standard_hi_is_booked() {
		final Room room = Rooms.roomsByFloorAndRoom.get(1).get(2);

		final LocalDate friday = LocalDate.now().with(DayOfWeek.FRIDAY);
		final LocalDate saturday = LocalDate.now().with(DayOfWeek.SATURDAY);

		_assert_cant_book(room, friday, saturday);
	}

	@Test
	public void _11_book_1d_suite_low_is_booked() {
		final Room room = Rooms.roomsByFloorAndRoom.get(1).get(11);

		final LocalDate monday = LocalDate.now().with(DayOfWeek.MONDAY);
		final LocalDate thursday = LocalDate.now().with(DayOfWeek.THURSDAY);

		_assert_cant_book(room, monday, thursday);
	}

	@Test
	public void _12_book_1d_suite_hi_is_booked() {
		final Room room = Rooms.roomsByFloorAndRoom.get(1).get(18);

		final LocalDate friday = LocalDate.now().with(DayOfWeek.FRIDAY);
		final LocalDate saturday = LocalDate.now().with(DayOfWeek.SATURDAY);

		_assert_cant_book(room, friday, saturday);
	}

	@Test
	public void _13_book_1w_standard_is_booked() {
		final Room room = Rooms.roomsByFloorAndRoom.get(1).get(3);

		final LocalDate monday = LocalDate.now().with(DayOfWeek.MONDAY);
		final LocalDate sunday = LocalDate.now().with(DayOfWeek.SUNDAY);

		_assert_cant_book(room, monday, monday.plus(1, ChronoUnit.DAYS));
		_assert_cant_book(room, monday.plus(4, ChronoUnit.DAYS), sunday);
		_assert_cant_book(room, monday, sunday);
	}

	@Test
	public void _14_book_1w_suite_is_booked() {
		final Room room = Rooms.roomsByFloorAndRoom.get(1).get(35);

		final LocalDate _2019_01_01 = LocalDate.of(2019, Month.JANUARY, 1);
		final LocalDate monday = _2019_01_01.with(DayOfWeek.MONDAY);
		final LocalDate sunday = _2019_01_01.with(DayOfWeek.SUNDAY);

		_assert_cant_book(room, monday, monday.plus(1, ChronoUnit.DAYS));
		_assert_cant_book(room, monday.plus(4, ChronoUnit.DAYS), sunday);
		_assert_cant_book(room, monday, sunday);
	}

	@Test
	public void _15_book_1m_standard_is_booked() {
		final Room room = Rooms.roomsByFloorAndRoom.get(1).get(4);

		final LocalDate _2018_12_01 = LocalDate.of(2018, Month.DECEMBER, 1);
		final LocalDate _2018_12_31 = LocalDate.of(2018, Month.DECEMBER, 31);

		_assert_cant_book(room, _2018_12_01, _2018_12_31);
		_assert_cant_book(room, _2018_12_01, _2018_12_01.plus(1, ChronoUnit.DAYS));
		_assert_cant_book(room, _2018_12_01.plus(10, ChronoUnit.DAYS), _2018_12_01.plus(12, ChronoUnit.DAYS));
		_assert_cant_book(room, _2018_12_31.minus(1, ChronoUnit.DAYS), _2018_12_31);
	}

	@Test
	public void _16_book_1m_suite_is_booked() {
		final Room room = Rooms.roomsByFloorAndRoom.get(1).get(36);

		final LocalDate _2018_12_01 = LocalDate.of(2018, Month.DECEMBER, 1);
		final LocalDate _2018_12_31 = LocalDate.of(2018, Month.DECEMBER, 31);

		_assert_cant_book(room, _2018_12_01, _2018_12_31);
		_assert_cant_book(room, _2018_12_01, _2018_12_01.plus(1, ChronoUnit.DAYS));
		_assert_cant_book(room, _2018_12_01.plus(20, ChronoUnit.DAYS), _2018_12_01.plus(21, ChronoUnit.DAYS));
		_assert_cant_book(room, _2018_12_31.minus(1, ChronoUnit.DAYS), _2018_12_31);
	}

	private void _assert_can_book(Room room, LocalDate checkIn, LocalDate checkOut) {
		//Expected
		final BigDecimal expectedPrice = new Book(checkIn, checkOut, room).price();

		//Actual
		final BookReq request = new BookReq(checkIn, checkOut);
		final String url = Config.BASE_URL.concat(String.format(RESOURCE, room.getFloor(), room.getRoom()));

		final ResponseEntity<BookRes> resp = restTemplate.postForEntity(url, request, BookRes.class);
		final BookRes respBody = resp.getBody();

		assertThat(resp.getStatusCode(), is(HttpStatus.OK));
		bookedRooms.add(room);
		assertThat(respBody, is(notNullValue()));
		assertThat(respBody.getBooked(), is(true));
		assertThat(respBody.getPrice(), is(expectedPrice));
	}

	private void _assert_cant_book(Room room, LocalDate checkIn, LocalDate checkOut) {
		//Actual
		final BookReq request = new BookReq(checkIn, checkOut);
		final String url = Config.BASE_URL.concat(String.format(RESOURCE, room.getFloor(), room.getRoom()));

		final ResponseEntity<BookRes> resp = restTemplate.postForEntity(url, request, BookRes.class);
		final BookRes respBody = resp.getBody();

		assertThat(resp.getStatusCode(), is(HttpStatus.OK));
		assertThat(respBody, is(notNullValue()));
		assertThat(respBody.getBooked(), is(false));
	}
}
