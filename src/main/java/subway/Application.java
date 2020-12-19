package subway;

import subway.domain.EdgeRepository;
import subway.domain.StationRepository;
import subway.domain.SubwayGraph;

public class Application {
    public static void main(String[] args) {
        Settings.init();

        MainService.view();
    }
}
