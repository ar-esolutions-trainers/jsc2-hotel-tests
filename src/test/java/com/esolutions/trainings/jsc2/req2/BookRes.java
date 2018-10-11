package com.esolutions.trainings.jsc2.req2;

import java.math.BigDecimal;

public class BookRes {
	private Boolean booked;
	private BigDecimal price;

	public Boolean getBooked() {
		return booked;
	}

	public void setBooked(Boolean booked) {
		this.booked = booked;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookRes{" +
				"booked=" + booked +
				", price=" + price +
				'}';
	}
}
