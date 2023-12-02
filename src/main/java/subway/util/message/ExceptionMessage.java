package subway.util.message;

import subway.util.constants.EnumUtil;

public enum ExceptionMessage implements EnumUtil<String, String> {
    BLANK_MESSAGE("%s은(는) 빈 값이 들어올 수 없습니다.")
    , LENGTH_MESSAGE("%d글자를 초과하였습니다.")
    , INPUT_MESSAGE("입력 중에 예기치 못한 오류가 발생하였습니다. 예외 메시지: %s")
    , TYPE_MESSAGE("%s은(는) 숫자만 입력할 수 있습니다.")
    , RANGE_MESSAGE("%d 보다 큰 값을 입력해 주세요.")
    , UNIT_MESSAGE("%d원 단위로 입력해 주세요.")
    , DUPLICATE_MESSAGE("%s을(를) 중복으로 입력할 수 없습니다.")
    , NO_RESOURCE_MESSAGE("%s(이)가 존재하지 않습니다.")
    , SAME_AS("출발역과 도착역이 동일합니다.")
    , NO_CONNECT_AS_STATION("%s와 %s는 서로 연결되어있지 않습니다.");
    private static final String ERROR_TAG = "\n[ERROR] ";
    private final String message;

    public String getMessage(){
        return message;
    }

    ExceptionMessage(final String message) {
        this.message = ERROR_TAG + message;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return message;
    }
}
