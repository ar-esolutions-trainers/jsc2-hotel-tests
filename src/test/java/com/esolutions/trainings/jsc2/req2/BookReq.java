package com.esolutions.trainings.jsc2.req2;

import java.time.LocalDate;

public class BookReq {
	private final LocalDate checkIn;
	private final LocalDate checkOut;

	BookReq(LocalDate checkIn, LocalDate checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	@Override
	public String toString() {
		return "BookReq{" +
				"checkIn=" + checkIn +
				", checkOut=" + checkOut +
				'}';
	}
}
