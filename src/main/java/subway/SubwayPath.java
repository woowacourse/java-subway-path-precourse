package subway;

import subway.domain.data.Station;
import subway.domain.data.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import java.util.Scanner;

public class SubwayPath {

    private Scanner scanner;

    public SubwayPath(Scanner scanner) {
        this.scanner = scanner;

        run();
    }

    private void run(){
        OutputView.printMainView();
        String order = selectMenu();
    }

    private String selectMenu(){
        try {
            OutputView.printAskingFunction();
            return InputView.getMainMenu(scanner);
        } catch (IllegalArgumentException e){
            OutputView.printError(e.getMessage());
            return selectMenu();
        }
    }

    private void initData(){
        initStation();
        //initLine();
        //initPath();
    }

    private void initStation() {
        String[] stations = {"교대역", "강남역", "역삼역"
                , "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};

        for(String station : stations) {
            StationRepository.addStation(new Station(station));
        }
    }

}
