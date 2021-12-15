package subway.Controller.Run;

import java.util.List;

import subway.View.OutputView;
import subway.domain.Path.DistanceConnectionRepository;
import subway.domain.Path.TimeConnectionRepository;
import subway.domain.Station;

public class OutputController {
	public static void getOutput(List<Station> path) {
		OutputView.printResult();
		OutputView.printFullDistance(getFullDistance(path));
		OutputView.printFullTime(getFullTime(path));
		OutputView.printPath(path);
	}

	public static int getFullDistance(List<Station> path) {
		int fullDistance = 0;
		for (int i = 0; i < path.size() - 1; i++) {
			fullDistance += DistanceConnectionRepository.findDistance(
				path.get(i), path.get(i + 1)
			);
		}
		return fullDistance;
	}

	public static int getFullTime(List<Station> path) {
		int fullTime = 0;
		for (int i = 0; i < path.size() - 1; i++) {
			fullTime += TimeConnectionRepository.findTime(
				path.get(i), path.get(i + 1)
			);
		}
		return fullTime;
	}
}
