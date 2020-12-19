package subway;

import java.util.Scanner;

public class Subway {
	public static void run(Scanner scanner) {
		while (true) {
			View view = new View(scanner);
//			Initializer.run();
			
			while (true) {
				view.main();
			}
		}
	}
}
