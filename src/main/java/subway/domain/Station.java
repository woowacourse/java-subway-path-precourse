package subway.domain;

public class Station {

    private static final String WHITE_SPACE = " ";
    private static final String RULE_STATION_NAME = "역";
    private static final int LAST_INDEX = 1;
    private static final int MINIMUM_NAME_LENGTH = 3;

    private String name;

    private Station(String name) {
        validateWhiteSpace(name);
        this.name = name;
    }

    private void validateWhiteSpace(String name) {
        if(name.contains(WHITE_SPACE)){
            throw new IllegalArgumentException("지하철 역 이름에 공백이 포함될 수 없습니다.");
        }
    }

    public static Station newStationWithName(String name) {
        return new Station(name);
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
