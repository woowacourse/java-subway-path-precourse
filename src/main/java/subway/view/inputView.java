package subway.view;

import static subway.common.Logger.guidePrint;

import java.util.Scanner;

public class InputView {

	public static String inputFunctionNumber(Scanner scanner) {
		guidePrint("원하는 기능을 선택하세요. ");
		return scanner.nextLine();
	}

	public static String inputDepartureStation(Scanner scanner) {
		System.out.println();
		guidePrint("출발역을 입력하세요. ");
		return scanner.nextLine();
	}

	public static String inputArrivalStation(Scanner scanner) {
		System.out.println();
		guidePrint("도착역을 입력하세요. ");
		return scanner.nextLine();
	}

}
