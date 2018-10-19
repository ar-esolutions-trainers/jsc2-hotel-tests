package com.esolutions.trainings.jsc2.req2;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rooms {
	static final Map<Integer, Map<Integer, Room>> roomsByFloorAndRoom;
	static {
		roomsByFloorAndRoom = Stream.of(
				new Room.Standard(1, 1),
				new Room.Standard(1, 2),
				new Room.Standard(1, 3),
				new Room.Standard(1, 4),
				new Room.Standard(1, 5),
				new Room.Standard(1, 6),
				new Room.Standard(1, 7),
				new Room.Standard(1, 8),
				new Room.Standard(1, 9),
				new Room.Standard(1, 10),
				new Room.Suite(1, 11),
				new Room.Standard(1, 12),
				new Room.Standard(1, 13),
				new Room.Standard(1, 14),
				new Room.Standard(1, 15),
				new Room.Standard(1, 16),
				new Room.Standard(1, 17),
				new Room.Suite(1, 18),
				new Room.Standard(1, 19),
				new Room.Standard(1, 20),
				new Room.Standard(1, 21),
				new Room.Standard(1, 22),
				new Room.Standard(1, 23),
				new Room.Standard(1, 24),
				new Room.Standard(1, 25),
				new Room.Standard(1, 26),
				new Room.Standard(1, 27),
				new Room.Standard(1, 28),
				new Room.Standard(1, 29),
				new Room.Standard(1, 30),
				new Room.Standard(1, 31),
				new Room.Standard(1, 32),
				new Room.Standard(1, 33),
				new Room.Standard(1, 34),
				new Room.Suite(1, 35),
				new Room.Suite(1, 36),
				new Room.Standard(1, 37),
				new Room.Standard(1, 38),
				new Room.Standard(1, 39),
				new Room.Standard(1, 40),
				new Room.Standard(1, 41),
				new Room.Standard(1, 42),
				new Room.Standard(1, 43),
				new Room.Standard(1, 44),
				new Room.Suite(1, 45),
				new Room.Standard(1, 46),
				new Room.Standard(1, 47),
				new Room.Standard(1, 48),
				new Room.Standard(1, 49),
				new Room.Standard(1, 50),
				new Room.Standard(2, 1),
				new Room.Standard(2, 2),
				new Room.Standard(2, 3),
				new Room.Standard(2, 4),
				new Room.Standard(2, 5),
				new Room.Standard(2, 6),
				new Room.Standard(2, 7),
				new Room.Standard(2, 8),
				new Room.Standard(2, 9),
				new Room.Standard(2, 10),
				new Room.Standard(2, 11),
				new Room.Standard(2, 12),
				new Room.Standard(2, 13),
				new Room.Standard(2, 14),
				new Room.Standard(2, 15),
				new Room.Standard(2, 16),
				new Room.Standard(2, 17),
				new Room.Standard(2, 18),
				new Room.Standard(2, 19),
				new Room.Standard(2, 20),
				new Room.Standard(2, 21),
				new Room.Standard(2, 22),
				new Room.Standard(2, 23),
				new Room.Standard(2, 24),
				new Room.Standard(2, 25),
				new Room.Standard(2, 26),
				new Room.Standard(2, 27),
				new Room.Standard(2, 28),
				new Room.Standard(2, 29),
				new Room.Standard(2, 30),
				new Room.Standard(2, 31),
				new Room.Standard(2, 32),
				new Room.Standard(2, 33),
				new Room.Standard(2, 34),
				new Room.Standard(2, 35),
				new Room.Standard(2, 36),
				new Room.Standard(2, 37),
				new Room.Standard(2, 38),
				new Room.Standard(2, 39),
				new Room.Standard(2, 40),
				new Room.Standard(2, 41),
				new Room.Standard(2, 42),
				new Room.Standard(2, 43),
				new Room.Standard(2, 44),
				new Room.Standard(2, 45),
				new Room.Standard(2, 46),
				new Room.Standard(2, 47),
				new Room.Standard(2, 48),
				new Room.Standard(2, 49),
				new Room.Standard(2, 50),
				new Room.Standard(3, 1),
				new Room.Standard(3, 2),
				new Room.Standard(3, 3),
				new Room.Standard(3, 4),
				new Room.Standard(3, 5),
				new Room.Standard(3, 6),
				new Room.Standard(3, 7),
				new Room.Standard(3, 8),
				new Room.Standard(3, 9),
				new Room.Standard(3, 10),
				new Room.Standard(3, 11),
				new Room.Standard(3, 12),
				new Room.Standard(3, 13),
				new Room.Suite(3, 14),
				new Room.Standard(3, 15),
				new Room.Standard(3, 16),
				new Room.Standard(3, 17),
				new Room.Standard(3, 18),
				new Room.Standard(3, 19),
				new Room.Standard(3, 20),
				new Room.Standard(3, 21),
				new Room.Standard(3, 22),
				new Room.Standard(3, 23),
				new Room.Standard(3, 24),
				new Room.Standard(3, 25),
				new Room.Standard(3, 26),
				new Room.Standard(3, 27),
				new Room.Standard(3, 28),
				new Room.Standard(3, 29),
				new Room.Standard(3, 30),
				new Room.Suite(3, 31),
				new Room.Standard(3, 32),
				new Room.Suite(3, 33),
				new Room.Suite(3, 34),
				new Room.Standard(3, 35),
				new Room.Standard(3, 36),
				new Room.Standard(3, 37),
				new Room.Standard(3, 38),
				new Room.Suite(3, 39),
				new Room.Standard(3, 40),
				new Room.Standard(3, 41),
				new Room.Suite(3, 42),
				new Room.Standard(3, 43),
				new Room.Standard(3, 44),
				new Room.Standard(3, 45),
				new Room.Standard(3, 46),
				new Room.Standard(3, 47),
				new Room.Standard(3, 48),
				new Room.Suite(3, 49),
				new Room.Standard(3, 50),
				new Room.Standard(4, 1),
				new Room.Standard(4, 2),
				new Room.Suite(4, 3),
				new Room.Standard(4, 4),
				new Room.Standard(4, 5),
				new Room.Suite(4, 6),
				new Room.Standard(4, 7),
				new Room.Suite(4, 8),
				new Room.Standard(4, 9),
				new Room.Standard(4, 10),
				new Room.Standard(4, 11),
				new Room.Standard(4, 12),
				new Room.Standard(4, 13),
				new Room.Suite(4, 14),
				new Room.Standard(4, 15),
				new Room.Standard(4, 16),
				new Room.Standard(4, 17),
				new Room.Standard(4, 18),
				new Room.Standard(4, 19),
				new Room.Standard(4, 20),
				new Room.Standard(4, 21),
				new Room.Standard(4, 22),
				new Room.Standard(4, 23),
				new Room.Suite(4, 24),
				new Room.Standard(4, 25),
				new Room.Standard(4, 26),
				new Room.Standard(4, 27),
				new Room.Standard(4, 28),
				new Room.Standard(4, 29),
				new Room.Standard(4, 30),
				new Room.Standard(4, 31),
				new Room.Suite(4, 32),
				new Room.Suite(4, 33),
				new Room.Standard(4, 34),
				new Room.Standard(4, 35),
				new Room.Standard(4, 36),
				new Room.Standard(4, 37),
				new Room.Standard(4, 38),
				new Room.Standard(4, 39),
				new Room.Standard(4, 40),
				new Room.Suite(4, 41),
				new Room.Standard(4, 42),
				new Room.Standard(4, 43),
				new Room.Standard(4, 44),
				new Room.Suite(4, 45),
				new Room.Standard(4, 46),
				new Room.Standard(4, 47),
				new Room.Standard(4, 48),
				new Room.Suite(4, 49),
				new Room.Standard(4, 50),
				new Room.Standard(5, 1),
				new Room.Suite(5, 2),
				new Room.Standard(5, 3),
				new Room.Standard(5, 4),
				new Room.Standard(5, 5),
				new Room.Standard(5, 6),
				new Room.Standard(5, 7),
				new Room.Standard(5, 8),
				new Room.Standard(5, 9),
				new Room.Standard(5, 10),
				new Room.Suite(5, 11),
				new Room.Suite(5, 12),
				new Room.Standard(5, 13),
				new Room.Standard(5, 14),
				new Room.Standard(5, 15),
				new Room.Standard(5, 16),
				new Room.Standard(5, 17),
				new Room.Standard(5, 18),
				new Room.Suite(5, 19),
				new Room.Standard(5, 20),
				new Room.Standard(5, 21),
				new Room.Standard(5, 22),
				new Room.Standard(5, 23),
				new Room.Standard(5, 24),
				new Room.Standard(5, 25),
				new Room.Standard(5, 26),
				new Room.Standard(5, 27),
				new Room.Standard(5, 28),
				new Room.Standard(5, 29),
				new Room.Standard(5, 30),
				new Room.Standard(5, 31),
				new Room.Suite(5, 32),
				new Room.Standard(5, 33),
				new Room.Standard(5, 34),
				new Room.Standard(5, 35),
				new Room.Suite(5, 36),
				new Room.Standard(5, 37),
				new Room.Standard(5, 38),
				new Room.Standard(5, 39),
				new Room.Standard(5, 40),
				new Room.Standard(5, 41),
				new Room.Standard(5, 42),
				new Room.Standard(5, 43),
				new Room.Standard(5, 44),
				new Room.Suite(5, 45),
				new Room.Standard(5, 46),
				new Room.Standard(5, 47),
				new Room.Suite(5, 48),
				new Room.Standard(5, 49),
				new Room.Standard(5, 50),
				new Room.Standard(6, 1),
				new Room.Standard(6, 2),
				new Room.Standard(6, 3),
				new Room.Standard(6, 4),
				new Room.Standard(6, 5),
				new Room.Standard(6, 6),
				new Room.Standard(6, 7),
				new Room.Standard(6, 8),
				new Room.Standard(6, 9),
				new Room.Standard(6, 10),
				new Room.Standard(6, 11),
				new Room.Standard(6, 12),
				new Room.Standard(6, 13),
				new Room.Standard(6, 14),
				new Room.Suite(6, 15),
				new Room.Standard(6, 16),
				new Room.Standard(6, 17),
				new Room.Standard(6, 18),
				new Room.Standard(6, 19),
				new Room.Standard(6, 20),
				new Room.Standard(6, 21),
				new Room.Standard(6, 22),
				new Room.Standard(6, 23),
				new Room.Standard(6, 24),
				new Room.Standard(6, 25),
				new Room.Standard(6, 26),
				new Room.Suite(6, 27),
				new Room.Standard(6, 28),
				new Room.Standard(6, 29),
				new Room.Standard(6, 30),
				new Room.Standard(6, 31),
				new Room.Standard(6, 32),
				new Room.Standard(6, 33),
				new Room.Standard(6, 34),
				new Room.Standard(6, 35),
				new Room.Standard(6, 36),
				new Room.Standard(6, 37),
				new Room.Standard(6, 38),
				new Room.Standard(6, 39),
				new Room.Standard(6, 40),
				new Room.Standard(6, 41),
				new Room.Standard(6, 42),
				new Room.Standard(6, 43),
				new Room.Standard(6, 44),
				new Room.Standard(6, 45),
				new Room.Standard(6, 46),
				new Room.Standard(6, 47),
				new Room.Suite(6, 48),
				new Room.Standard(6, 49),
				new Room.Standard(6, 50)
		).collect(Collectors.groupingBy(Room::getFloor, Collectors.toMap(Room::getRoom, Function.identity())));
	}

}