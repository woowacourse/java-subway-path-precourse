package subway.common;

public class Logger {
	public static final String LEVEL_GUIDE = "## ";
	public static final String LEVEL_ERROR = "\n[ERROR] ";
	public static final String LEVEL_INFO = "[INFO] ";

	public static void guidePrint(String errorBody) {
		System.out.print(LEVEL_GUIDE + errorBody + "\n");
	}

	public static void errorPrint(String errorBody) {
		System.out.println(LEVEL_ERROR + errorBody);
	}

	public static void infoPrint(String infoBody) {
		System.out.print(LEVEL_INFO + infoBody + "\n");
	}
}
