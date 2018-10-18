package com.esolutions.trainings.jsc2.req2;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class BookReq {
	private final LocalDate checkIn;
	private final LocalDate checkOut;

	BookReq(LocalDate checkIn, LocalDate checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public LocalDate getCheckIn() {
		return checkIn;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
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
