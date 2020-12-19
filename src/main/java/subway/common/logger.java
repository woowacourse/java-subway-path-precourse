package subway.common;

public class logger {
	public static final String LEVEL_GUIDE = "## ";
	public static final String LEVEL_ERROR = "[ERROR] ";
	public static final String LEVEL_INFO = "[INFO] ";

	public static void guidePrint(String errorBody) {
		System.out.print(LEVEL_GUIDE + errorBody + "\n");
	}

	public static void errorPrint(String errorBody) {
		System.out.println(LEVEL_ERROR + errorBody + "\n");
	}

	public static void infoPrint(String infoBody) {
		System.out.print(LEVEL_INFO + infoBody + "\n");
	}
}
