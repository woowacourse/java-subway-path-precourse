package subway.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.jgrapht.alg.shortestpath.DijkstraManyToManyShortestPaths;
import org.jgrapht.graph.DefaultWeightedEdge;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.SubwayException;
import subway.menu.MainMenu;
import subway.menu.PathMenu;
import subway.utils.ValidateUtils;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    public static final String INVALID_CATEGORY_EXCEPTION_MESSAGE = "잘못된 값을 입력했습니다.";
    public static final String NO_ROUTE_EXCEPTION_MESSAGE = "경로가 존재하지 않습니다.";
    private static final String[] initialStations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역",
        "양재시민의숲역", "매봉역"};
    public static DijkstraManyToManyShortestPaths<String, org.jgrapht.graph.DefaultWeightedEdge> timeGraphPath;
    private static DijkstraManyToManyShortestPaths<String, org.jgrapht.graph.DefaultWeightedEdge> distanceGraphPath;
    private final InputView inputView;

    public SubwayController(InputView inputView) {
        this.inputView = inputView;
        SectionRepository sectionRepository = new SectionRepository();
        distanceGraphPath = new DijkstraManyToManyShortestPaths<>(
            sectionRepository.getDistanceGraph());
        timeGraphPath = new DijkstraManyToManyShortestPaths<>(sectionRepository.getTimeGraph());
    }

    private static void exitMain() {
        System.exit(0);
    }

    private static String findPathCategory(String inputCategory) {
        return Arrays.stream(PathMenu.values())
            .filter(value -> value.category.equals(inputCategory.toUpperCase()))
            .findFirst()
            .orElseThrow(() -> new SubwayException(INVALID_CATEGORY_EXCEPTION_MESSAGE))
            .category;
    }

    public void run() {
        initializeSubway();
        MainMenu.startManage();
        printMainCategory();
    }

    private void initializeSubway() {
        Arrays.stream(initialStations)
            .forEach(station -> StationRepository.addStation(new Station(station)));
    }

    private void printMainCategory() {
        OutputView.chooseCategory();
        try {
            executeMainCategory(inputView.inputValue());
        } catch (SubwayException exception) {
            OutputView.showErrorMessage(exception);
            printMainCategory();
        }
    }

    public void executeMainCategory(String inputCategory) {
        String category = findMainCategory(inputCategory);
        if (category.equals(MainMenu.PATH.category)) {
            printPathCategory();
            executePathCategory(inputView.inputValue());
        }
        if (category.equals(MainMenu.EXIT.category)) {
            exitMain();
        }
    }

    private String findMainCategory(String inputCategory) {
        return Arrays.stream(MainMenu.values())
            .filter(value -> value.category.equals(inputCategory.toUpperCase()))
            .findFirst()
            .orElseThrow(() -> new SubwayException(INVALID_CATEGORY_EXCEPTION_MESSAGE))
            .category;
    }

    private void printPathCategory() {
        PathMenu.startManage();
        OutputView.chooseCategory();
        try {
            executePathCategory(inputView.inputValue());
        } catch (SubwayException exception) {
            OutputView.showErrorMessage(exception);
            printPathCategory();
        }
    }

    public void executePathCategory(String inputCategory) {
        String category = findPathCategory(inputCategory);
        try {
            executePathCategoryImmediately(category);
            MainMenu.startManage();
            printMainCategory();
        } catch (SubwayException exception) {
            OutputView.showErrorMessage(exception);
            printPathCategory();
        }
    }

    private void executePathCategoryImmediately(String category) {
        if (category.equals(PathMenu.DISTANCE.category)) {
            findMinimumDistance();
            return;
        }
        if (category.equals(PathMenu.TIME.category)) {
            findMinimumTime();
        }
    }

    public void findMinimumDistance() {
        findMinimum(distanceGraphPath);
    }

    public void findMinimumTime() {
        findMinimum(timeGraphPath);
    }

    private void findMinimum(DijkstraManyToManyShortestPaths<String, DefaultWeightedEdge> timeGraphPath) {
        String startStation = inputStartStation();
        String endStation = inputEndStation();
        ValidateUtils.isSame(startStation, endStation);
        try {
            List<String> shortestPath = findPath(startStation, endStation, timeGraphPath);
            printRoutes(shortestPath);
        } catch (NullPointerException exception) {
            throw new SubwayException(NO_ROUTE_EXCEPTION_MESSAGE);
        }
    }

    private List<String> findPath(String startStation, String endStation,
        DijkstraManyToManyShortestPaths<String, DefaultWeightedEdge> distanceGraphPath) {
        return distanceGraphPath.getPath(startStation, endStation)
            .getVertexList();
    }

    private void printRoutes(List<String> shortestPath) {
        ArrayList<String> path = listToArray(shortestPath);
        int timeSum = calculateTime(path);
        int distanceSum = calculateDistance(path);
        OutputView.printResult(distanceSum, timeSum);
        shortestPath.forEach(OutputView::showInfoMessage);
    }


    private int calculateTime(ArrayList<String> path) {
        return calculateWithGraph(path, timeGraphPath);
    }

    private int calculateDistance(ArrayList<String> path) {
        return calculateWithGraph(path, distanceGraphPath);
    }

    private int calculateWithGraph(ArrayList<String> path,
        DijkstraManyToManyShortestPaths<String, DefaultWeightedEdge> GraphPath) {
        List<Double> weights = new ArrayList<>();
        IntStream.range(0, path.size() - 1)
            .forEach(value -> weights.add(GraphPath.getPath(
                path.get(value),
                path.get(value + 1)).getWeight()));
        return calculateSum(weights);
    }

    private int calculateSum(List<Double> weights) {
        int timeSum = 0;
        for (Double weight : weights) {
            timeSum += weight;
        }
        return timeSum;
    }

    private ArrayList listToArray(List<String> list) {
        ArrayList array = new ArrayList(list);
        return array;
    }

    private String inputEndStation() {
        OutputView.printEndStation();
        return inputView.inputStation();
    }

    private String inputStartStation() {
        OutputView.printStartStation();
        return inputView.inputStation();
    }
}
