package subway;

import subway.domain.section.SectionRepository;
import subway.domain.section.SectionService;
import subway.domain.station.StationService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        DataInitService dataInitService = new DataInitService(new StationService(), new SectionService(new SectionRepository()));
        dataInitService.init();

        SubwayManageApp subwayManageApp = new SubwayManageApp(new InputView(scanner), new OutputView(new StringBuilder()));
        subwayManageApp.startApp();
    }
}
