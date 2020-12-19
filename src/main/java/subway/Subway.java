package subway;

import java.util.Scanner;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.StationRepository;
import subway.view.MainView;

public class Subway {

    private final StationRepository stationRepository = new StationRepository();
    private final LineRepository lineRepository = new LineRepository();
    private final SectionRepository sectionRepository = new SectionRepository();

    public void launch(Scanner scanner) {
        MainView mainView = new MainView(this, scanner);
        mainView.start();
    }


}
