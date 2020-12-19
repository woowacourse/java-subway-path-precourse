package subway;

import org.junit.jupiter.api.BeforeAll;
import subway.domain.RouteRepository;

public class PathRepositoryTest {
    private static RouteRepository routeRepository;
    @BeforeAll
    public static void init() {
        Application.init();
        RouteRepository.init();
    }

}
