package subway.view;

public class OutputView {
	private static final String ERROR_FORMAT = "[ERROR] %s%n";
	private static final String MESSAGE_FORMAT = "## %s%n";

	private static final String REQUEST_SELECT_FUNCTION = "원하는 기능을 선택하세요.";

	public static void requestSelectFunction() {
		System.out.println(REQUEST_SELECT_FUNCTION);
	}

	public static void print(String message) {
		System.out.println(message);
		System.out.println();
	}

	public static void printError(Exception e) {
		System.out.printf(ERROR_FORMAT, e.getMessage());
		printEmptyLine();
	}
	
	public static void printEmptyLine(){
		System.out.println();
	}
}
