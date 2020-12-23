package subway;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.controller.RouteController;
import subway.exception.TransitRouteException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RouteControllerTest {
    @DisplayName("예외 : 출발역과 도착역이 같을 경우")
    @Test
    void When_같은출발역과도착역일경우최소시간_Expect_예외() {
        String departure = "강남역";
        String arrival = "강남역";
        assertThatThrownBy(() -> RouteController.showRouteByTime(departure, arrival))
                .isInstanceOf(TransitRouteException.class)
                .hasMessage("[ERROR] 출발역과 도착역이 동일합니다.");
    }

    @DisplayName("예외 : 출발역과 도착역이 같을 경우")
    @Test
    void When_같은출발역과도착역일경우최단거리_Expect_예외() {
        String departure = "강남역";
        String arrival = "강남역";
        assertThatThrownBy(() -> RouteController.showRouteByDistance(departure, arrival))
                .isInstanceOf(TransitRouteException.class)
                .hasMessage("[ERROR] 출발역과 도착역이 동일합니다.");
    }
}
