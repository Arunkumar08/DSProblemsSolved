package arun.problems.ds;

import java.util.List;


public class SpotBlueCar {

	public void findBlueCar(List<Floor> parkingLot, String findTheColor) {
		for(final Floor floor : parkingLot) {
			for(final ParkRows row : floor.rows) {
				for(final Car car : row.cars) {
					if(findTheColor.equals(car.color)) {
						System.out.println("Floor: " + floor.floorId + ", Row: " + row.rowId + " CarNo. " +car.number);
					}
				}
			}
		}
	}
}

class Floor {
	String floorId;
	List<ParkRows> rows;
}

class ParkRows {
	String rowId;
	List<Car> cars;
}

class Car {
	String number;
	String color;
}