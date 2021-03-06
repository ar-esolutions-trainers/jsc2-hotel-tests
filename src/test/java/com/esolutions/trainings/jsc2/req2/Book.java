package com.esolutions.trainings.jsc2.req2;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

public class Book {
	private final LocalDate checkIn;
	private final LocalDate checkOut;
	private final Room room;

	Book(LocalDate checkIn, LocalDate checkOut, Room room) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.room = room;
	}

	private Stream<LocalDate> days() {
		return Stream.iterate(checkIn, d -> d.plusDays(1))
				.limit(Period.between(checkIn, checkOut).get(ChronoUnit.DAYS));
	}

	public BigDecimal price() {
		return this.days()
				.map(Price::ofDay)
				.map(p -> BigDecimal.valueOf(p.priceOfRoom(this.room)))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
