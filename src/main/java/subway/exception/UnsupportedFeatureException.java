package subway.exception;

import subway.util.ErrorViewUtil;

public class UnsupportedFeatureException extends IllegalArgumentException {
    private static final String errorMessage = "메뉴에서 지원하지 않는 기능입니다.";

    public UnsupportedFeatureException() {
        super(ErrorViewUtil.getErrorPrefix() + " " + errorMessage);
    }
}
