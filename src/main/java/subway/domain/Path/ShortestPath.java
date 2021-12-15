package subway.domain.Path;

import java.util.List;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

import subway.Utils.Constants;
import subway.Utils.Validator.PathValidator;
import subway.domain.Station;
import subway.domain.StationRepository;

public class ShortestPath {
	private List<Station> path;
	private final String name1;
	private final String name2;

	public ShortestPath(String name1, String name2) {
		this.name1 = name1;
		this.name2 = name2;
		new PathValidator(name1, name2);
	}

	public List<Station> getDistancePath() {
		makeDistancePath();
		if (path.isEmpty()) {
			throw new IllegalArgumentException(Constants.ERROR_NOT_CONNECTED);
		}
		return path;
	}

	public List<Station> getTimePath() {
		makeTimePath();
		if (path.isEmpty()) {
			throw new IllegalArgumentException(Constants.ERROR_NOT_CONNECTED);
		}
		return path;
	}

	private void makeTimePath() {
		path = new DijkstraShortestPath(TimeConnectionRepository.connections())
			.getPath(
				StationRepository.getStation(name1),
				StationRepository.getStation(name2)
			).getVertexList();
	}

	private void makeDistancePath() {
		path = new DijkstraShortestPath(DistanceConnectionRepository.connections())
			.getPath(
				StationRepository.getStation(name1),
				StationRepository.getStation(name2)
			).getVertexList();
	}
}
