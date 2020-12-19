package subway;

public enum MainType {
    FIND_PATH("1","경로 조회"),
    EXIT("Q","종료");

    private String command;
    private String typeName;

    MainType(String command, String typeName) {
        this.command = command;
        this.typeName = typeName;
    }

    public String getCommand() {
        return this.command;
    }

    public String getTypeName() {
        return this.typeName;
    }
}
