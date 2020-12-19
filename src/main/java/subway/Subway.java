package subway;

import java.util.List;
import java.util.Scanner;

import org.jgrapht.graph.DefaultWeightedEdge;

import subway.domain.StationRepository;
import subway.util.Message;
import subway.util.Output;

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
		List<DefaultWeightedEdge> sectionList;
		double distance;
		
		if (StationRepository.contains(departureStation) && StationRepository.contains(arrivalStation)) {
			// 최단 거리 계산 기능 구현
			sectionList = StationRepository.getSectionDistanceList(departureStation, arrivalStation);
			distance = StationRepository.getSectionDistance(departureStation, arrivalStation);
			printMinDistance(distance, sectionList);
			return;
		}
		Output.error(Message.NOT_CONTAIN_STATION);
	}
	
	public static void printMinDistance(double distance, List<DefaultWeightedEdge> sectionList) {
		Output.info(Message.LINE_SEPARATOR);
		Output.distance(distance);
		Output.info(Message.LINE_SEPARATOR);
		for (DefaultWeightedEdge station: sectionList) {
			Output.section(station);
		}
	}
	
	public static void minTimeBetween(String departureStation, String arrivalStation) {
		List<DefaultWeightedEdge> sectionList;
		double time;
		
		if (StationRepository.contains(departureStation) && StationRepository.contains(arrivalStation)) {
			// 최단 거리 계산 기능 구현
			sectionList = StationRepository.getSectionTimeList(departureStation, arrivalStation);
			time = StationRepository.getSectionTime(departureStation, arrivalStation);
			printMinTime(time, sectionList);
		}
	}
	
	public static void printMinTime(double time, List<DefaultWeightedEdge> sectionList) {
		Output.info(Message.LINE_SEPARATOR);
		Output.time(time);
		Output.info(Message.LINE_SEPARATOR);
		for (DefaultWeightedEdge station: sectionList) {
			Output.section(station);
		}
	}
	
	public static void exit() {
		Output.print(Message.EXIT);
		System.exit(0);
	}
	
	public static void back() {
		Output.print(Message.PRINT_BACK_TO_MAIN);
	}
}
