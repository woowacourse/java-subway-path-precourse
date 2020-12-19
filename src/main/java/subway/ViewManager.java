package subway;

import java.util.Scanner;

import subway.util.Input;
import subway.util.Message;
import subway.util.Output;

public class ViewManager {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void showMinDistance() {
		String departureStation;
		String arrivalStation;
		
		Output.title(Message.DEPARTURE_STATION_INPUT);
		departureStation = Input.nextLine(scanner);
		
		Output.title(Message.ARRIVAL_STATION_INPUT);
		arrivalStation = Input.nextLine(scanner);
		
		
	}
}
