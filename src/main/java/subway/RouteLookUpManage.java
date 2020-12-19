package subway;

import static subway.common.errorCase.FUNCTION_INPUT_ERROR;
import static subway.common.logger.errorPrint;
import static subway.view.inputView.inputFunctionNumber;
import static subway.view.outputView.printPathTypes;

import java.util.Scanner;

public class RouteLookUpManage {
	private final static String SHORTEST_DISTANCE = "1";
	private final static String MINIMUM_TIME = "2";
	private final static String BACK = "B";

	public static void routeLookUpManage(Scanner scanner) {
		boolean exitFlag = false;
		while (!exitFlag) {
			printPathTypes();
			exitFlag = isLookUpExit(scanner);
		}
	}

	private static boolean isLookUpExit(Scanner scanner) {
		String input = inputFunctionNumber(scanner);
		if (input.equals(BACK)) {
			return true;
		}
		if (input.equals(SHORTEST_DISTANCE)) {
			//findPathByDistance(scanner);
			return false;
		}
		if (input.equals(MINIMUM_TIME)) {
			//findPathByTime(scanner);
			return false;
		}
		errorPrint(FUNCTION_INPUT_ERROR);
		return false;
	}
}
