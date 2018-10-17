package com.esolutions.trainings.jsc2.req2;

public abstract class Room {
	private final int floor;
	private final int room;

	Room(int floor, int room) {
		this.floor = floor;
		this.room = room;
	}

	public int getFloor() {
		return floor;
	}

	public int getRoom() {
		return room;
	}

	public abstract double lowPrice();

	public abstract double hiPrice();

	static final class Standard extends Room {
		Standard(int floor, int room) {
			super(floor, room);
		}

		@Override
		public double lowPrice() {
			return 150.99;
		}

		@Override
		public double hiPrice() {
			return 191.99;
		}
	}

	static final class Suite extends Room {
		Suite(int floor, int room) {
			super(floor, room);
		}

		@Override
		public double lowPrice() {
			return 187.99;
		}

		@Override
		public double hiPrice() {
			return 202.99;
		}
	}

}
