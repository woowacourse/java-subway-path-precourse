package subway.util.message;

import subway.util.constants.EnumUtil;

public enum OutputMessage implements EnumUtil<String, String> {
    DASH(" --- "),
    TOTAL_DISTANCE(" 총 거리 : "),
    TOTAL_TIME(" 총 소요 시간: "),
    KILLOMETER("km"),
    MINUTE("분");

    private String message;
    private static final String INFO_TAG = "[INFO] ";

    OutputMessage(String message){
        this.message = INFO_TAG + message;
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
