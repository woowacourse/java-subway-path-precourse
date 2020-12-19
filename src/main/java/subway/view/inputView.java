package subway.view;

import static subway.common.logger.guidePrint;

import java.util.Scanner;

public class inputView {

	public static String inputFunctionNumber(Scanner scanner) {
		guidePrint("원하는 기능을 선택하세요. ");
		return scanner.nextLine();
	}
}
