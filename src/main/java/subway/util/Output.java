package subway.util;

import org.jgrapht.graph.DefaultWeightedEdge;

public class Output {
	public static void mainView() {
		Output.title(Message.MAIN_VIEW);
		Output.print(Message.PATH_RESULT);
		Output.print(Message.QUITE);
		Output.title(Message.FUNCTION_CHOICE);
	}
	
	public static void pathView() {
		Output.title(Message.PATH_CRITERION_VIEW);
		Output.print(Message.MIN_DISTANCE);
		Output.print(Message.MIN_TIME);
		Output.print(Message.BACK);
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
	
	public static void distance(double distance) {
		System.out.println("[INFO] 총 거리: " + distance + "km");
	}
	
	public static void time(double time) {
		System.out.println("[INFO] 총 소요 시간: " + time + "분");
	}
	
	public static void section(DefaultWeightedEdge station) {
		System.out.println("[INFO] " + station);
	}
}
