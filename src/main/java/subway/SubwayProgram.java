package subway;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.controller.Initializer;
import subway.controller.MainMenu;
import subway.domain.DistanceRepository;

import java.util.Scanner;

public class SubwayProgram {
    private final Scanner scanner;

    public SubwayProgram(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        initializeData();
        MainMenu mainMenu = new MainMenu(scanner);
        do {
            mainMenu.run();
        } while (mainMenu.doNext());

        //아래는 테스트용 출력 코드 제출전 지우기
//        StationRepository.printAllStations();
//        LineRepository.printAllLinesAndStation();
    }

    private void initializeData() {
        Initializer.stationInitialize();
        Initializer.lineInitialize();
        DistanceRepository.initializePathByDistance();
    }
}
