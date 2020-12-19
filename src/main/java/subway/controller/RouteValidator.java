package subway.controller;

import subway.domain.LineRepository;

public class RouteValidator {
    private static final String STATION_NAME_FORMAT = "[가-힣]{0,}역";

    public void validateStationName(String stationName) {
        if (!stationName.matches(STATION_NAME_FORMAT)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 역 이름입니다.");
        }
    }
    
    public void validateStationIsExisted(String stationName) {
        if (!LineRepository.hasStation(stationName)) {
            throw new IllegalArgumentException("[ERROR] 노선에 존재하지 않는 역입니다.");
        }
    }
    
    public void validateStartEqualsEnd(String startStation, String endStation) {
        if (startStation.equals(endStation)) {
            throw new IllegalArgumentException("[ERROR] 출발역과 도착역이 같습니다.");
        }
    }
    
    public void validateStartIsNotConnectedWithEnd(String startStation, String endStation) {
        // 출발역과 도착역이 연결되어 있지 않으면 에러
    }
}
