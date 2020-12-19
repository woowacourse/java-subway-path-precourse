package subway;

import subway.domain.data.Line;
import subway.domain.data.LineRepository;
import subway.domain.data.Station;
import subway.domain.data.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubwayPath {

    private Scanner scanner;

    public SubwayPath(Scanner scanner) {
        this.scanner = scanner;

        run();
    }

    private void run() {
        OutputView.printMainView();
        String order = selectMenu();
    }

    private String selectMenu() {
        try {
            OutputView.printAskingFunction();
            return InputView.getMainMenu(scanner);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return selectMenu();
        }
    }

    private void initData() {
        initStation();
        initLine();
        //initPath();
    }

    private void initLine() {
        List<Line> lineList = setInitLines();

        for(Line line : lineList) {
            LineRepository.addLine(line);
        }
    }

    private List<Line> setInitLines() {
        List<Line> lineList = new ArrayList<>();
        String[] lineNames = {"2호선", "3호선", "신분당선"};

        for (String lineName : lineNames) {
            Line line = new Line(lineName);
            line.addStationListInLine(getStationsInLine(lineName));
            lineList.add(line);
        }

        return lineList;
    }

    private List<Station> getStationsInLine(String lineName) {
        String[] lineNameList = initLineNames(lineName);
        List<Station> stationList = new ArrayList<>();

        for (String name : lineNameList) {
            stationList.add(new Station(name));
        }

        return stationList;
    }

    private String[] initLineNames(String lineName) {
        String[] line2 = {"교대역", "강남역", "역삼역"};
        String[] line3 = {"교대역", "남부터미널역", "양재역", "매봉역"};
        String[] lineSinbundang = {"강남역", "양재역", "양재시민의숲역"};

        if (lineName.equals("2호선")) {
            return line2;
        }
        if (lineName.equals("3호선")) {
            return line3;
        }

        return lineSinbundang;
    }

    private void initStation() {
        String[] stations = {"교대역", "강남역", "역삼역"
                , "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};

        for (String station : stations) {
            StationRepository.addStation(new Station(station));
        }
    }

}
