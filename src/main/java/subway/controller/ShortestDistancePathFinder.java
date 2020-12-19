package subway.controller;

import java.util.List;
import java.util.Scanner;
import subway.controller.constants.ControllerConstant;
import subway.domain.StationDistanceRespository;
import subway.domain.StationTimeRepository;
import subway.view.PathOutputView;

public class ShortestDistancePathFinder extends ShortestPathFinder {
    public ShortestDistancePathFinder(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void showPath(String departure, String terminal) {
        int shortestDistance = StationDistanceRespository.getShortestDistance(departure, terminal);
        List<String> shortestDistancePath =
                StationDistanceRespository.getShortestPath(departure, terminal);
        int consumedTime = getTimeOnShortestPath(shortestDistancePath);
        PathOutputView.showCheckedResult(shortestDistancePath, shortestDistance, consumedTime);
    }

    private int getTimeOnShortestPath(List<String> shortestDistancePath) {
        int time = ControllerConstant.ZERO_NUMBER;

        for (int i = ControllerConstant.ZERO_NUMBER;
                i < shortestDistancePath.size() - ControllerConstant.ONE_NUMBER; i++) {
            String departure = shortestDistancePath.get(i);
            String terminal = shortestDistancePath.get(i + ControllerConstant.ONE_NUMBER);
            time = time + StationTimeRepository.getShortestTime(departure, terminal);
        }

        return time;
    }
}
