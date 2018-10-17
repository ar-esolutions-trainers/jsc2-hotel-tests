package com.esolutions.trainings.jsc2.req2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

public class Book {
	private final LocalDate checkIn;
	private final LocalDate checkOut;
	private final int floor;
	private final int room;

	Book(LocalDate checkIn, LocalDate checkOut, int floor, int room) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.floor = floor;
		this.room = room;
	}

	private Stream<LocalDate> days() {
		return Stream.iterate(checkIn, d -> d.plusDays(1))
				.limit(Period.between(checkIn, checkOut).get(ChronoUnit.DAYS));
	}

	public double price() {
		final Room room = Rooms.roomsByFloorAndRoom.get(floor).get(this.room);

		return this.days()
				.map(Price::ofDay)
				.mapToDouble(p -> p.priceOfRoom(room))
				.sum();
	}
}
