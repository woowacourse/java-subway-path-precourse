package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class DefaultData {
    private final static String[] STATIONS = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    private final static String[] LINES = {"2호선", "3호선", "신분당선"};
    private final static String[] LINE_TWO = {"교대역", "강남역", "역삼역"};
    private final static int[] LINE_TWO_LENGTH = {2, 2};
    private final static int[] LINE_TWO_TIME = {3, 3};
    private final static String[] LINE_THREE = {"교대역", "남부터미널역", "양재역", "매봉역"};
    private final static int[] LINE_THREE_LENGTH = {3, 6, 1};
    private final static int[] LINE_THREE_TIME = {2, 5, 1};
    private final static String[] LINE_SHIN = {"강남역", "양재역", "양재시민의숲역"};
    private final static int[] LINE_SHIN_LENGTH = {2, 10};
    private final static int[] LINE_SHIN_TIME = {10, 3};

    public DefaultData(){
        addDefaultStations();
        addDefaultLines();
        setLineInformation();
    }

    private void addDefaultStations(){
        for(String station : STATIONS){
            StationRepository.addStation(new Station(station));
        }
    }

    private void addDefaultLines(){
        for(String line : LINES){
            LineRepository.addLine(new Line(line));
        }
    }

    private void setLineInformation(){
        setDefaultLineTwo();
        setDefaultLineThree();
        setDefaultLineShin();
    }

    private void setDefaultLineTwo(){
        Line line = LineRepository.getLine("2호선");
        for(int i = 0; i<LINE_TWO.length-1; i++){
            line.addInformation(LINE_TWO[i], LINE_TWO[i+1], LINE_TWO_TIME[i], LINE_TWO_LENGTH[i]);
        }
    }

    private void setDefaultLineThree(){
        Line line = LineRepository.getLine("3호선");
        for(int i = 0; i<LINE_THREE.length-1; i++){
            line.addInformation(LINE_THREE[i], LINE_THREE[i+1], LINE_THREE_TIME[i], LINE_THREE_LENGTH[i]);
        }
    }

    private void setDefaultLineShin(){
        Line line = LineRepository.getLine("신분당선");
        for(int i = 0; i<LINE_SHIN.length-1; i++){
            line.addInformation(LINE_SHIN[i], LINE_SHIN[i+1], LINE_SHIN_TIME[i], LINE_SHIN_LENGTH[i]);
        }
    }
}
