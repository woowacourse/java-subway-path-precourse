package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class InitSetting {

    private static String[] initStation = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    private static String[] initLine = {"2호선", "3호선", "신분당선"};
    private static String[][] initSection = {{"교대역", "강남역", "역삼역"}, {"교대역", "남부터미널역", "양재역", "매봉역"}, {"강남역", "양재역", "양재시민의숲역"}};
    // "km, 분"
    private static String[][] initCost = {{"2,3", "2,3"}, {"3,2", "6,5", "1,1"}, {"2,8", "10,3"}};


    public static void initSetting() {
        setInitStation();
        setInitLine();
        setInitSection();
        setInitCost();
    }

    private static void setInitStation() {
        for (String name : initStation) {
            StationRepository.addStation(new Station(name));
        }
    }

    private static void setInitLine() {
        for (String name : initLine) {
            LineRepository.addLine(new Line(name));
        }
    }

    private static void setInitSection() {
        for (int i = 0; i < initSection.length; i++) {
            for (String name : initSection[i]) {
                LineRepository.addSection(i, name);
            }
        }
    }

    private static void setInitCost() {
        for (int i = 0; i < initCost.length; i++) {
            for (int j = 0; j < initCost[i].length; j++) {
                String[] cost = initCost[i][j].split(",");
                int distanceCost = Integer.parseInt(cost[0]);
                int timeCost = Integer.parseInt(cost[1]);
                String curStation = initSection[i][j];
                String nextStation = initSection[i][j + 1];
                StationRepository.setCost(curStation, nextStation, timeCost, distanceCost);
            }
        }
    }
}
