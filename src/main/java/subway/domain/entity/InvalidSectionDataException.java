package subway.domain.entity;

public class InvalidSectionDataException extends RuntimeException {
    private static final String ERROR_MESSAGE = "구간의 거리 및 시간 정보는 1 이상의 양의 정수여야 합니다.";

    public InvalidSectionDataException() {
        super(ERROR_MESSAGE);
    }
}
