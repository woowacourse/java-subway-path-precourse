package subway.Controller.Run;

import subway.Utils.Constants;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Path.DistanceConnectionRepository;
import subway.domain.Path.TimeConnectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Init {
	public static void initiate() {
		setStationRepository();
		setLineRepository();
		setConnectionRepository();
		setDistanceConnectionRepository();
		setTimeConnectionRepository();
	}

	private static void setStationRepository() {
		for (String s : Constants.STATIONS) {
			StationRepository.addStation(new Station(s));
		}
		DistanceConnectionRepository.addAllVertex();
		TimeConnectionRepository.addAllVertex();
	}

	private static void setLineRepository() {
		for (String s : Constants.LINES) {
			LineRepository.addLine(new Line(s));
		}
	}

	private static void setConnectionRepository() {
		for (Object[] distances : Constants.DISTANCES) {
			DistanceConnectionRepository.addConnection(
				StationRepository.getStation((String)distances[0]),
				StationRepository.getStation((String)distances[1]),
				(Integer)distances[2]);
		}
	}

	private static void setDistanceConnectionRepository() {
		for (Object[] distances : Constants.DISTANCES) {
			DistanceConnectionRepository.addConnection(
				StationRepository.getStation((String)distances[0]),
				StationRepository.getStation((String)distances[1]),
				(Integer)distances[2]);
		}
	}

	private static void setTimeConnectionRepository() {
		for (Object[] times : Constants.TIMES) {
			TimeConnectionRepository.addConnection(
				StationRepository.getStation((String)times[0]),
				StationRepository.getStation((String)times[1]),
				(Integer)times[2]);
		}
	}
}
