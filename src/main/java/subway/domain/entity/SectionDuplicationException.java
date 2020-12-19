package subway.domain.entity;

public class SectionDuplicationException extends RuntimeException {
    private static final String ERROR_MESSAGE = "지하철 노선의 구간에는 중복되는 지하철 역이 존재할 수 없습니다.";

    public SectionDuplicationException() {
        super(ERROR_MESSAGE);
    }
}
