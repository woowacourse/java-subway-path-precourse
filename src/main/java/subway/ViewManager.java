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
		Subway.minDistanceBetween(getDepartureStation(), getArrivalStation());
	}
	
	public static void showMinTime() {
		Subway.minTimeBetween(getDepartureStation(), getArrivalStation());
	}
}
