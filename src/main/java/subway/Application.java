package subway;

import java.util.Scanner;

import subway.Controller.StationsController;

public class Application {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		new StationsController(scanner);
	}
}
