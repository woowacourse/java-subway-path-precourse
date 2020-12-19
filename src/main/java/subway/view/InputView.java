package subway.view;

import java.util.Scanner;

public class InputView {

	private final static Scanner scanner = new Scanner(System.in);

	public static String selectFunction() {
		System.out.println(OutputView.SElECT_FUNCTION);
		String selection = scanner.nextLine();
		return selection;
	}

	public static String getDepartureStation() {
		System.out.println(OutputView.DEPARTURE_STATION);
		String departureStation = scanner.nextLine();
		return departureStation;
	}

	public static String getArrivalStation() {
		System.out.println(OutputView.ARRIVAL_STATION);
		String arrivalStation = scanner.nextLine();
		return arrivalStation;
	}
}
