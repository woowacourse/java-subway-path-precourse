package subway.domain;

import java.util.*;

public class LineRepository {
    private static final int 교대에서_강남_거리 = 2;
    private static final int 교대에서_강남_시간 = 3;
    private static final int 강남에서_역삼_거리 = 2;
    private static final int 강남에서_역삼_시간 = 3;
    private static final int 교대에서_남부터미널_거리 = 3;
    private static final int 교대에서_남부터미널_시간 = 2;
    private static final int 남부터미널에서_양재_거리 = 6;
    private static final int 남부터미널에서_양재_시간 = 5;
    private static final int 양재에서_매봉_거리 = 1;
    private static final int 양재에서_매봉_시간 = 1;
    private static final int 강남에서_양재_거리 = 2;
    private static final int 강남에서_양재_시간 = 8;
    private static final int 양재에서_양재시민의숲_거리 = 10;
    private static final int 양재에서_양재시민의숲_시간 = 3;


    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }

    public void lineInitialization() {
        Line secondLine = new Line("2호선");
        secondLine.setLineStations(new ArrayList<Station>(Arrays.asList(StationRepository.getStationByName("교대역"), StationRepository.getStationByName("강남역"), StationRepository.getStationByName("역삼역"))));
        secondLine.setLineDistances(new ArrayList<Distance>(Arrays.asList(new Distance(교대에서_강남_거리, 교대에서_강남_시간), new Distance(강남에서_역삼_거리, 강남에서_역삼_시간))));

        Line thirdLine = new Line("3호선");
        thirdLine.setLineStations(new ArrayList<Station>(Arrays.asList(StationRepository.getStationByName("교대역"), StationRepository.getStationByName("남부터미널역"), StationRepository.getStationByName("양재역"), StationRepository.getStationByName("매봉역"))));
        thirdLine.setLineDistances(new ArrayList<Distance>(Arrays.asList(new Distance(교대에서_남부터미널_거리, 교대에서_남부터미널_시간), new Distance(남부터미널에서_양재_거리, 남부터미널에서_양재_시간), new Distance(양재에서_매봉_거리, 양재에서_매봉_시간))));
        
        Line newBundangLine = new Line("신분당선");
        newBundangLine.setLineStations(new ArrayList<Station>(Arrays.asList(StationRepository.getStationByName("강남역"), StationRepository.getStationByName("양재역"), StationRepository.getStationByName("양재시민의숲역"))));
        newBundangLine.setLineDistances(new ArrayList<Distance>(Arrays.asList(new Distance(강남에서_양재_거리, 강남에서_양재_시간), new Distance(양재에서_양재시민의숲_거리, 양재에서_양재시민의숲_시간))));

        LineRepository.addLine(secondLine);
        LineRepository.addLine(thirdLine);
        LineRepository.addLine(newBundangLine);
    }
}
