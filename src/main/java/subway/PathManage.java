package subway;

import subway.domain.Constants;
import subway.domain.Init;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.View;

import java.util.List;
import java.util.Scanner;

import static subway.Application.startProgram;

public class PathManage {
    public static void managePath(Scanner kbd) {
        View.showPathMenu();
        String input = InputView.inputFunction(kbd, Constants.SUB_FUNCTIONS);
        if (input.equals(Constants.MIN_DISTANCE))
            findMinDistance(kbd);
        if (input.equals(Constants.MIN_TIME))
            findMinTime(kbd);
        if (input.equals(Constants.GO_BACK_MENU))
            startProgram(kbd);
    }

    public static void findMinDistance(Scanner kbd) {
        try {
            String[] stations = InputView.inputSrcDest(kbd);
            List<String> shortestPath = Init.dijkstraDistance.getPath(stations[0], stations[1]).getVertexList();
            getMinPath(Constants.PATH_DISTANCE, shortestPath, getMinValue(stations));
            startProgram(kbd);
        } catch (Exception e) {
            startProgram(kbd);
        }
    }

    public static void findMinTime(Scanner kbd) {
        try {
            String[] stations = InputView.inputSrcDest(kbd);
            List<String> shortestPath = Init.dijkstraTime.getPath(stations[0], stations[1]).getVertexList();
            getMinPath(Constants.PATH_TIME, shortestPath, getMinValue(stations));
            startProgram(kbd);
        } catch (Exception e) {
            startProgram(kbd);
        }
    }

    public static void getMinPath(String name, List<String> path, int[] values) {
        Line minPath = new Line(name);
        LineRepository.addLine(minPath, path);
        View.displayPath(minPath, values[0], values[1]);
        LineRepository.deleteLineByName(name);
    }

    public static int[] getMinValue(String[] stations) {
        double time = Init.dijkstraTime.getPath(stations[0], stations[1]).getWeight();
        double distance = Init.dijkstraDistance.getPath(stations[0], stations[1]).getWeight();
        int[] values = new int[2];
        values[0] = (int) Math.round(time);
        values[1] = (int) Math.round(distance);
        return values;
    }
}
