package subway;

import java.util.Scanner;

import subway.domain.StationRepository;

public class Subway {
	public static void run(Scanner scanner) {
		while (true) {
			View view = new View(scanner);
			Initializer.run();
			
			while (true) {
				view.main();
			}
		}
	}
	
	public static void minDistanceBetween(String departureStation, String arrivalStation) {
		if (StationRepository.contains(departureStation) && StationRepository.contains(arrivalStation)) {
			// 최단 거리 계산 기능 구현
		}
	}
}
