package subway.util.constants;

public enum LineName implements EnumUtil<String, String>{
    LINE_2("2호선"),
    LINE_3("3호선"),
    SHIN_BUNDANG("신분당선");

    private String lineName;

    LineName(String lineName){
        this.lineName = lineName;
    }

    @Override
    public String getKey() {
        return lineName;
    }

    @Override
    public String getValue() {
        return name();
    }
}
