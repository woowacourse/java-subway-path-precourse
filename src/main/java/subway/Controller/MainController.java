package subway.Controller;


import subway.View.InputView;
import subway.View.OutputView;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainController {
    private static final String MAIN_CONTROLLER_MENU_QUIT="Q";
    private static final String MAIN_CONTROLLER_PATH_SEARCH="1";
    private static final List<String> station= Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    private static final List<String> line=Arrays.asList("2호선","3호선","신분당선");
    Scanner scanner;
    OutputView outputView=new OutputView();
    InputView inputView=new InputView();
    PathController pathController=new PathController();
    LineRepository lineRepository=new LineRepository();

    public MainController(Scanner scanner){
        this.scanner=scanner;
        startMainMenu(scanner);
    }
    public void startMainMenu(Scanner scanner) {
        while(true) {
                initializeSubwayStation();
                initializeSubwayLine();
                initializeDistance();
                initializeTime();
                outputView.setMainMenuMainDisplay();
                String tmpSaveMenuChoice = inputView.getChooseFunction(scanner);
                if (tmpSaveMenuChoice.equals(MAIN_CONTROLLER_MENU_QUIT)) {
                    break;
                }
                if (tmpSaveMenuChoice.equals(MAIN_CONTROLLER_PATH_SEARCH)) {
                    pathController.startPathMenu(scanner);
                    continue;
                }
        }
    }
    public void initializeSubwayStation() {
        for(int i=0;i<station.size();i++) {
            StationRepository.addStation(new Station(station.get(i)));
        }
    }
    public void initializeSubwayLine() {
        lineRepository.initializeLine(line.get(0),Arrays.asList(station.get(0),station.get(1),station.get(2)));
        lineRepository.initializeLine(line.get(1),Arrays.asList(station.get(0),station.get(3),station.get(4),station.get(6)));
        lineRepository.initializeLine(line.get(2),Arrays.asList(station.get(1),station.get(4),station.get(5)));
    }
    public void initializeTime() {
        List<Integer> time=Arrays.asList(3,2,5,1,8);
        lineRepository.getLine(line.get(0)).setTime(Arrays.asList(time.get(0), time.get(0)));
        lineRepository.getLine(line.get(1)).setTime(Arrays.asList(time.get(1), time.get(2),time.get(3)));
        lineRepository.getLine(line.get(2)).setTime(Arrays.asList(time.get(4), time.get(0)));

    }
    public void initializeDistance() {
        List<Integer> distance=Arrays.asList(2,3,6,10,1);
        lineRepository.getLine(line.get(0)).setDistance(Arrays.asList(distance.get(0), distance.get(0)));
        lineRepository.getLine(line.get(1)).setDistance(Arrays.asList(distance.get(1), distance.get(2),distance.get(4)));
        lineRepository.getLine(line.get(2)).setDistance(Arrays.asList(distance.get(0), distance.get(3)));
    }

}
