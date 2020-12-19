package subway.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.jgrapht.alg.shortestpath.DijkstraManyToManyShortestPaths;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.SubwayException;
import subway.menu.MainMenu;
import subway.menu.PathMenu;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    private static final String[] initialStations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역",
        "양재시민의숲역", "매봉역"};
    private static final String[] initialLines = {"2호선", "3호선", "신분당선"};
    private static final String LineTwo = "2호선";
    private static final String LineThree = "3호선";
    private static final String LineSinBunDang = "신분당선";
    private final InputView inputView;
    private final SectionRepository sectionRepository;
    private static DijkstraManyToManyShortestPaths<String, org.jgrapht.graph.DefaultWeightedEdge> distanceGraphPath;
    public static DijkstraManyToManyShortestPaths<String, org.jgrapht.graph.DefaultWeightedEdge> timeGraphPath;

    public SubwayController(InputView inputView) {
        this.inputView = inputView;
        sectionRepository = new SectionRepository();
        distanceGraphPath = new DijkstraManyToManyShortestPaths<>(SectionRepository.getDistanceGraph());
        timeGraphPath = new DijkstraManyToManyShortestPaths<>(SectionRepository.getTimeGraph());
    }


    public void run() {
        initializeSubway();
        MainMenu.startManage();
        printMainCategory();
    }

    private void initializeSubway() {
        Arrays.stream(initialStations)
            .forEach(station -> StationRepository.addStation(new Station(station)));
        Arrays.stream(initialLines)
            .forEach(line -> LineRepository.addLine(new Line(line)));
        initialLineTwo();
        initialLineThree();
        initialLineSinBunDang();
    }

    private void initialLineSinBunDang() {
        Line sinBunDang = LineRepository.findLine(LineSinBunDang);
        sinBunDang.addByName("강남역");
        sinBunDang.addByName("양재역");
        sinBunDang.addByName("양재시민의숲역");
    }

    private void initialLineThree() {
        Line three = LineRepository.findLine(LineThree);
        three.addByName("교대역");
        three.addByName("남부터미널역");
        three.addByName("양재역");
        three.addByName("매봉역");

    }

    private void initialLineTwo() {
        Line two = LineRepository.findLine(LineTwo);
        two.addByName("교대역");
        two.addByName("강남역");
        two.addByName("역삼역");
    }

    private void printMainCategory() {
        OutputView.chooseCategory();
        try {
            mainExecute(inputView.inputValue());
        } catch (SubwayException exception) {
            OutputView.showErrorMessage(exception);
            printMainCategory();
        }
    }

    public void mainExecute(String inputCategory) {
        String category = findMainCategory(inputCategory);
        if(category.equals("1")){
            PathMenu.startManage();
            printPathCategory();
            pathExecute(inputView.inputValue());
        }
        if(category.equals("Q")){
            exitMain();
        }
    }

    private String findMainCategory(String inputCategory) {
        return Arrays.stream(MainMenu.values())
            .filter(value -> value.category.equals(inputCategory.toUpperCase()))
            .findFirst()
            .orElseThrow(() -> new SubwayException("잘못된 값을 입력했습니다."))
            .category;
    }

    private static void exitMain() {
        System.exit(0);
    }

    private void printPathCategory() {
        OutputView.chooseCategory();
        try {
            pathExecute(inputView.inputValue());
        } catch (SubwayException exception) {
            OutputView.showErrorMessage(exception);
            printPathCategory();
        }
    }

    public  void pathExecute(String inputCategory) {
        String category = findPathCategory(inputCategory);
        if(category.equals("1")){
            findMinimumDistance();
            return;
        }
        if (category.equals("2")){
            findMinimumTime();
            return;
        }

    }

    private static String findPathCategory(String inputCategory) {
        return Arrays.stream(PathMenu.values())
            .filter(value -> value.category.equals(inputCategory.toUpperCase()))
            .findFirst()
            .orElseThrow(() -> new SubwayException("잘못된 값을 입력했습니다."))
            .category;
    }

    public void findMinimumDistance() {
        String startStation = inputStartStation();
        String endStation = inputEndStation();
        List<String> shortestPath = distanceGraphPath.getPath(startStation,endStation).getVertexList();
        ArrayList<String> path = listToArray(shortestPath);
        int timeSum = calculateTime(path);
        int distanceSum = calculateDistance(path);
        System.out.println(timeSum);
        OutputView.printResult(distanceSum, timeSum);
        shortestPath.forEach(OutputView::showInfoMessage);

    }

    public void findMinimumTime() {
        String startStation = inputStartStation();
        String endStation = inputEndStation();
        List<String> shortestPath = timeGraphPath.getPath(startStation,endStation).getVertexList();
        ArrayList<String> path = listToArray(shortestPath);
        int timeSum = calculateTime(path);
        int distanceSum = calculateDistance(path);
        System.out.println(timeSum);
        shortestPath.forEach(System.out::println);
        OutputView.printResult(timeSum, distanceSum);
    }

    private int calculateTime(ArrayList<String> path) {
        List<Double> totalTime = new ArrayList<>();
        IntStream.range(0, path.size() - 1).forEach(value -> totalTime.add(timeGraphPath.getPath(
            path.get(value),
            path.get(value + 1)).getWeight()));
        int timeSum = 0;
        for(int i=0; i<totalTime.size(); i++){
            timeSum += totalTime.get(i);
        }
        return timeSum;
    }

    private int calculateDistance(ArrayList<String> path) {
        List<Double> totalDistance = new ArrayList<>();
        IntStream.range(0, path.size() - 1).forEach(value -> totalDistance.add(distanceGraphPath.getPath(
            path.get(value),
            path.get(value + 1)).getWeight()));
        int timeSum = 0;
        for(int i=0; i<totalDistance.size(); i++){
            timeSum += totalDistance.get(i);
        }
        return timeSum;
    }

    private ArrayList<String> listToArray(List<String> list) {
        ArrayList<String> array = new ArrayList(list);
        return array;
    }

    private String inputEndStation() {
        OutputView.printEndStation();
        String input = inputView.inputValue();
        if(StationRepository.hasStation(input)){
            return input;
        }
        throw new SubwayException("존재하지 않는 역입니다.");
    }

    private String inputStartStation() {
        OutputView.printStartStation();
        String input = inputView.inputValue();
        if(StationRepository.hasStation(input)){
            return input;
        }
        throw new SubwayException("존재하지 않는 역입니다.");
    }
}
