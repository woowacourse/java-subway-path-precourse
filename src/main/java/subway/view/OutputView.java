package subway.view;

public class OutputView {
    public static final String ERROR_FORMAT = "[ERROR] %s%n";

	public static void printError(Exception e) {
		printEmptyLine();
		System.out.printf(ERROR_FORMAT, e.getMessage());
	}
	
	private static void printEmptyLine(){
		System.out.println();
	}
}
