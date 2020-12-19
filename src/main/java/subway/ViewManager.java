package subway;

import java.util.Scanner;

import subway.util.Input;
import subway.util.Message;
import subway.util.Output;

public class ViewManager {
	private static Scanner scanner = new Scanner(System.in);
	
	private static String getDepartureStation() {
		Output.title(Message.DEPARTURE_STATION_INPUT);
		return Input.nextLine(scanner);
	}
	
	private static String getArrivalStation() {
		Output.title(Message.ARRIVAL_STATION_INPUT);
		return Input.nextLine(scanner);
	}
	
	public static void showMinDistance() {
		String departureStation = getDepartureStation();
		String arrivalStation = getArrivalStation();
		
		if (Validator.isSameStation(departureStation, arrivalStation)) {
			Output.error(Message.SAME_STATION);
			return;
		}
		Subway.minDistanceBetween(departureStation, arrivalStation);
	}
	
	public static void showMinTime() {
		String departureStation = getDepartureStation();
		String arrivalStation = getArrivalStation();
		
		if (Validator.isSameStation(departureStation, arrivalStation)) {
			Output.error(Message.SAME_STATION);
			return;
		}
		Subway.minTimeBetween(departureStation, arrivalStation);
	}
}
