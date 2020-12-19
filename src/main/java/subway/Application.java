package subway;

import subway.domain.Edge;
import subway.domain.EdgeRepository;
import subway.service.MainService;

public class Application {
    public static void main(String[] args) {
        Settings.init();
        MainService.view();
    }
}
