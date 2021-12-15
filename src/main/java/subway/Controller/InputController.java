package subway.Controller;

import java.util.Scanner;

import subway.Utils.Constants;
import subway.View.InputView;
import subway.domain.StationRepository;

public class InputController {
	public static String getStartStationInput(Scanner scanner) {
		try {
			String input = InputView.inputStartStation(scanner);
			StationRepository.getStation(input);
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getStartStationInput(scanner);
		}
	}

	public static String getFinishStationInput(Scanner scanner) {
		try {
			String input = InputView.inputFinishStation(scanner);
			StationRepository.getStation(input);
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getFinishStationInput(scanner);
		}
	}

	public static String getMainInput(Scanner scanner) {
		try {
			String input = InputView.inputMain(scanner);
			if (!input.equals(Constants.MAIN_INPUT_START)
				&& !input.equals(Constants.MAIN_INPUT_QUIT)) {
				throw new IllegalArgumentException(Constants.ERROR_WRONG_MAIN_INPUT);
			}
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getMainInput(scanner);
		}
	}

	public static String getStandardInput(Scanner scanner) {
		try {
			String input = InputView.inputStandard(scanner);
			if (!input.equals(Constants.MAIN_STANDARD_DISTANCE)
				&& !input.equals(Constants.MAIN_STANDARD_TIME)
				&& !input.equals(Constants.MAIN_STANDARD_QUIT)) {
				throw new IllegalArgumentException(Constants.ERROR_WRONG_STANDARD_INPUT);
			}
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getMainInput(scanner);
		}
	}
}
