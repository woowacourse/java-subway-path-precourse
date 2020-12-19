package subway.exception;

import subway.view.Prefix;

public enum ErrorCode {
    //Selection
    INVALID_INPUT_VALUE("S001", "선택할 수 없는 기능입니다."),

    //Station
    STATION_EMTPY("ST001", "존재하지 않는 역입니다."),
    STATION_NAME_LENGTH_ERROR("ST002", Prefix.ERROR.getPrefix() + "역 이름은 2글자 이상이어야 합니다."),
    STATION_INVALID_LAST_NAME("ST003", Prefix.ERROR.getPrefix() + "마지막 글자에 역이 들어가야합니다."),
    STATION_INVALID_CHARACTER("ST004", Prefix.ERROR.getPrefix() + "한글, 숫자만 입력 가능합니다."),
    STATION_ALREADY_EXIST("ST005", Prefix.ERROR.getPrefix() + "이미 등록된 지하철 역입니다."),
    STATION_NOT_FOUND("ST006", Prefix.ERROR.getPrefix() + "입력된 이름으로 등록된 지하철 역이 없습니다."),

    //Line
    LINE_NAME_LENGTH_ERROR("L001", Prefix.ERROR.getPrefix() + "노선 이름은 2글자 이상이어야 합니다."),
    LINE_INVALID_LAST_NAME("L002", Prefix.ERROR.getPrefix() + "마지막 글자에 선이 들어가야합니다."),
    LINE_INVALID_CHARACTER("L003", Prefix.ERROR.getPrefix() + "한글, 숫자만 입력 가능합니다."),
    LINE_NOT_FOUND("S004", Prefix.ERROR.getPrefix() + "입력된 이름으로 등록된 노선이 없습니다."),
    LINE_ALREADY_EXIST("S005", Prefix.ERROR.getPrefix() + "이미 등록된 지하철 노선입니다."),

    //Section
    SECTION_SAME_STATION_NAME("SE001", Prefix.ERROR.getPrefix() + "상행 좀점역과 하행 종점역의 이름이 같을 수 없습니다."),
    SECTION_NOT_FOUND("SE002", Prefix.ERROR.getPrefix() + "입력된 이름으로 등록된 노선이 없습니다.");




    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
