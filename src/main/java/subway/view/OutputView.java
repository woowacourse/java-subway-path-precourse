package subway.view;

public class OutputView {
	private static final String ERROR_FORMAT = "[ERROR] %s%n";
	private static final String MESSAGE_FORMAT = "## %s%n";

	private static final String REQUEST_SELECT_FUNCTION = "원하는 기능을 선택하세요.";
	private static final String REQUEST_START_STATION = "출발역을 입력하세요.";
	private static final String REQUEST_END_STATION = "도착역을 입력하세요.";

	public static void requestSelectFunction() {
		printMessage(REQUEST_SELECT_FUNCTION);
	}

	public static void requestStartStation() {
		printMessage(REQUEST_START_STATION);
	}

	public static void requestEndStation() {
		printMessage(REQUEST_END_STATION);
	}

	public static void print(String message) {
		System.out.println(message);
		System.out.println();
	}

	public static void printError(Exception e) {
		System.out.printf(ERROR_FORMAT, e.getMessage());
		printEmptyLine();
	}

	private static void printMessage(String message) {
		System.out.printf(MESSAGE_FORMAT, message);
	}

	public static void printEmptyLine(){
		System.out.println();
	}
}
