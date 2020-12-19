package subway.initiator;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Path;
import subway.domain.PathBuilder;
import subway.domain.PathRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayMapInitiator {
	private static final Integer ZERO_INDEX = 0;
	private static final Integer LAST_INDEX = 1;
	private static final Integer NEXT_INDEX = 1;
	
	private static final String[] lineNames = { "2호선", "3호선", "신분당선" };
	private static final String[][] stationNames = { 
			{ "교대역", "강남역", "역삼역" }, 
			{ "교대역", "남부터미널역", "양재역", "매봉역" },
			{ "강남역", "양재역", "양재시민의숲역" } 
	};
	private static final int[][] distances = { 
			{ 2, 2 }, 
			{ 3, 6, 1 }, 
			{ 2, 10 } 
	};
	private static final int[][] minutes = { 
			{ 3, 3 }, 
			{ 2, 5, 1 },
			{ 8, 3 } 
	};

	public static void initiateRepository() {
		for (int row = ZERO_INDEX; row < lineNames.length; row++) {
			Line line = new Line(lineNames[row]);
			for (int col = ZERO_INDEX; col < stationNames[row].length - LAST_INDEX; col++) {
				String firstStationName = stationNames[row][col];
				String lastStationName = stationNames[row][col + NEXT_INDEX];
				Path path = new PathBuilder()
						.firstStation(firstStationName)
						.lastStation(lastStationName)
						.distance(distances[row][col])
						.minute(minutes[row][col])
						.build();
				line.addPath(path);
				PathRepository.addPath(path);
				StationRepository.addStation(new Station(firstStationName));
				StationRepository.addStation(new Station(lastStationName));
			}
			LineRepository.addLine(line);
		}
	}
}
