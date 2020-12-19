package subway;

public enum WeightType {
    DISTANCE("1","최단 거리"),
    TIME("2","최소 시간"),
    go_back("B","돌아가기");

    private String command;
    private String typeName;
    WeightType(String command, String typeName) {
        this.command = command;
        this.typeName = typeName;
    }

    public String getCommand() {
        return command;
    }

    public String getTypeName() {
        return typeName;
    }
}
