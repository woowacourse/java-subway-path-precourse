package subway.view;

import java.util.List;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import subway.domain.section.Distance;
import subway.domain.section.ResultDto;
import subway.domain.section.Time;
import subway.domain.station.Station;
import subway.screen.MainScreen;
import subway.screen.RouteScreen;

class OutputViewTest {

    @Test
    @Description("조회결과 출력 확인")
    public void printResultTest() {

        ResultDto result = ResultDto.create(Time.of(10), Distance.of(15));

        List<Station> stations = List.of(Station.of("강남역"), Station.of("남강역"), Station.of("부산역"));

        OutputView.printResult(stations,result);
    }

    @Test
    @Description("스크린 메뉴 출력 확인")
    public void printMenusTest(){

        OutputView.printMenus(MainScreen.EXIT);
        OutputView.printMenus(RouteScreen.DISTANCE);

    }

}