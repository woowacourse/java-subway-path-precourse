package subway;

import static subway.common.errorCase.FUNCTION_INPUT_ERROR;
import static subway.common.logger.errorPrint;
import static subway.view.inputView.inputFunctionNumber;
import static subway.view.outputView.printMain;

import java.util.Scanner;

public class Application {
	private final static String ROUTE_LOOKUP = "1";
	private final static String EXIT = "Q";

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		//initSetting();
		boolean exitFlag = false;
		while (!exitFlag) {
			printMain();
			exitFlag = isExit(scanner);
		}
	}

	private static boolean isExit(Scanner scanner) {
		String input = inputFunctionNumber(scanner);
		if (input.equals(EXIT)) {
			return true;
		}
		if (input.equals(ROUTE_LOOKUP)) {
			//routeLookUpManage(scanner);
			return false;
		}
		errorPrint(FUNCTION_INPUT_ERROR);
		return false;
	}
}
