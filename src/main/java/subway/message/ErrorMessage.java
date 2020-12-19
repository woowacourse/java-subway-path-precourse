package subway.message;

import subway.domain.Section;

public enum ErrorMessage {

    // 역 관련 에러 메시지
    // STATION_INVALID_NAME_LENGTH(String.format("역 이름은 %d자 이상이어야 합니다.", MIN_STATION_NAME_LENGTH)),

    // 노선 관련 에러 메시지
    // LINE_INVALID_NAME_LENGTH(String.format("노선 이름은 %d자 이상이어야 합니다.", MIN_LINE_NAME_LENGTH)),
    LINE_STATION_INDEX_OUT_OF_RANGE("역을 추가하려는 위치가 할당될 수 없는 위치입니다."),
    LINE_STATION_DOES_NOT_EXIST("제거하려는 역은 해당 노선에 없는 역입니다."),

    // 구간 관련 에러 메시지
    SECTION_ITEM_DUPLICATED("구간에는 같은 역이 여러 개 존재할 수 없습니다."),
    SECTION_STATIONS_TOO_SMALL(String.format("구간에는 최소 %d개의 역이 존재하여야 합니다.", Section.MIN_STATIONS_SIZE)),
    SECTION_GAPS_TOO_SMALL(String.format("구간에는 최소 %d개의 간격이 존재하여야 합니다.", Section.MIN_GAPS_SIZE)),
    SECTION_STATION_ALREADY_EXIST("추가하려는 역은 이미 해당 구간에 포함된 역입니다."),
    SECTION_GAPS_STATIONS_DIFFERENCE("구간의 크기는 역의 크기보다 1 작아야 합니다."),
    SECTION_STATION_INDEX_OUT_OF_RANGE("색인의 범위가 구간 내 역 갯수 범위를 초과했습니다."),
    SECTION_STATION_INDEXES_DIFFERENCE("두 색인의 차는 1이어야 합니다."),

    // 역 저장소 관련 에러 메시지
    STATION_REPOSITORY_STATION_ALREADY_EXIST("이미 등록된 역 이름입니다."),
    STATION_REPOSITORY_STATION_DOES_NOT_EXIST("존재하지 않는 역 이름입니다."),
    STATION_REPOSITORY_STATION_HAS_PARENT("구간에서 사용중인 역은 삭제할 수 없습니다."),
    STATION_REPOSITORY_EMPTY("역 저장소가 비어 있습니다."),

    // 노선 저장소 관련 에러 메시지
    LINE_REPOSITORY_LINE_ALREADY_EXIST("이미 등록된 노선 이름입니다."),
    LINE_REPOSITORY_LINE_DOES_NOT_EXIST("존재하지 않는 노선 이름입니다."),
    LINE_REPOSITORY_EMPTY("노선 저장소가 비어 있습니다."),

    // 구간 저장소 관련 에러 메시지
    SECTION_REPOSITORY_LINE_ALREADY_EXIST("추가하려는 노선은 이미 구간 내에 존재합니다."),

    // 메뉴 선택 관련 에러 메시지
    MENU_INVALID_SELECTION("선택할 수 없는 기능입니다."),

    // 입력 관련 에러 메시지
    INPUT_EMPTY_STRING("빈 문장은 입력할 수 없습니다."),
    INPUT_INVALID_STRING("올바르지 않은 입력 형식입니다."),

    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

}
