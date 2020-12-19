package subway.util;

public class Output {
	public static void mainView() {
		Output.title(Message.MAIN_VIEW);
		Output.print(Message.PATH_RESULT);
		Output.print(Message.QUITE);
		Output.title(Message.FUNCTION_CHOICE);
	}
	
	public static void title(String message) {
 		System.out.println("\n## " + message);
 	}
 	
 	public static void print(String message) {
 		System.out.println(message);
 	}
	
	public static void info(String message) {
		System.out.println("[INFO] " + message);
	}
	
	public static void error(String message) {
		System.out.println("[ERROR] " + message);
	}
}
