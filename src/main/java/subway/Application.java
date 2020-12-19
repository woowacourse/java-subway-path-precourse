package subway;

import static subway.RouteLookUpManage.routeLookUpManage;
import static subway.Setting.initSetting;
import static subway.common.ErrorCase.FUNCTION_INPUT_ERROR;
import static subway.common.Logger.errorPrint;
import static subway.view.InputView.inputFunctionNumber;
import static subway.view.OutputView.printMain;

import java.util.Scanner;

public class Application {
	private final static String ROUTE_LOOKUP = "1";
	private final static String EXIT = "Q";

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		initSetting();
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
			routeLookUpManage(scanner);
			return false;
		}
		errorPrint(FUNCTION_INPUT_ERROR);
		return false;
	}
}
