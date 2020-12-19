package subway.controller;

import java.util.List;
import java.util.Scanner;
import subway.controller.constants.ControllerConstant;
import subway.domain.StationDistanceRespository;
import subway.domain.StationTimeRepository;
import subway.view.PathOutputView;

public class ShortestTimePathFinder extends ShortestPathFinder {
    ShortestTimePathFinder(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void showPath(String departure, String terminal) {
        int shortestTime = StationTimeRepository.getShortestTime(departure, terminal);
        List<String> shortestTimePath =
                StationTimeRepository.getShortestPath(departure, terminal);
        int consumedDistance = getDistanceOnShortestTime(shortestTimePath);
        PathOutputView.showCheckedResult(shortestTimePath, consumedDistance, shortestTime);
    }

    private int getDistanceOnShortestTime(List<String> shortestTimePath) {
        int distance = ControllerConstant.ZERO_NUMBER;

        for (int i = ControllerConstant.ZERO_NUMBER;
                i < shortestTimePath.size() - ControllerConstant.ONE_NUMBER; i++) {
            String departure = shortestTimePath.get(i);
            String terminal = shortestTimePath.get(i + ControllerConstant.ONE_NUMBER);
            distance = distance + StationTimeRepository.getShortestTime(departure, terminal);
        }

        return distance;
    }
}
