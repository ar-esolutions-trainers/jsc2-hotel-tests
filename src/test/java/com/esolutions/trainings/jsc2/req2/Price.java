package com.esolutions.trainings.jsc2.req2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public abstract class Price {
	private static final List<DayOfWeek> WEEKENDS = Arrays.asList(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);

	private static final Price HI_PRICE = new Price() {
		@Override
		double priceOfRoom(Room r) {
			return r.hiPrice();
		}
	};

	private static final Price LOW_PRICE = new Price() {
		@Override
		double priceOfRoom(Room r) {
			return r.lowPrice();
		}
	};

	abstract double priceOfRoom(Room r);

	static Price ofDay(LocalDate d) {
		if (WEEKENDS.contains(d)) {
			return HI_PRICE;
		} else {
			return LOW_PRICE;
		}
	}
}
