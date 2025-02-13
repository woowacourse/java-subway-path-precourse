package subway.domain.line;

public class LineDTO {
    private static final String LINE_NAME_ESSENTIAL_MESSAGE = "노선 이름은 필수입니다.";

    private final String name;

    public LineDTO(String name) {
        this.validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(LINE_NAME_ESSENTIAL_MESSAGE);
        }
    }

    public String getName() {
        return this.name;
    }
}
